package com.sgpj.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgpj.backend.dto.GrupoPesquisaDTO;
import com.sgpj.backend.dto.GrupoPesquisaHistoricoDTO;
import com.sgpj.backend.dto.RequisicaoGrupoPesquisaDTO;
import com.sgpj.backend.exception.GrupoPesquisaNaoEncontradoException;
import com.sgpj.backend.exception.NomeGrupoExistenteException;
import com.sgpj.backend.mapper.GrupoPesquisaHistoricoMapper;
import com.sgpj.backend.mapper.GrupoPesquisaMapper;
import com.sgpj.backend.model.GrupoPesquisa;
import com.sgpj.backend.model.GrupoPesquisaHistorico;
import com.sgpj.backend.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.repository.RepositorioHistoricoGrupoPesquisa;

import io.camunda.zeebe.client.ZeebeClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class GrupoPesquisaService {

    private final ObjectMapper objectMapper;
    private final ZeebeClient zeebeClient;
    private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioHistoricoGrupoPesquisa grupoPesquisaHistoricoRepository;

    
    public GrupoPesquisaService(RepositorioGrupoPesquisa gruposPesquisaRepository, RepositorioHistoricoGrupoPesquisa grupoPesquisaHistoricoRepository ,ObjectMapper objectMapper,ZeebeClient zeebeClient) {
        this.gruposPesquisaRepository = gruposPesquisaRepository;
        this.grupoPesquisaHistoricoRepository = grupoPesquisaHistoricoRepository;
        this.zeebeClient = zeebeClient;
        this.objectMapper = objectMapper;
    }

    // Retornar todos os Grupos de Pesquisa do Banco de Dados
    public List<GrupoPesquisaDTO> getGruposPesquisa(){
        List<GrupoPesquisa> grupos = gruposPesquisaRepository.findAll();

        List<GrupoPesquisaDTO> gruposPesquisaDTOs = grupos.stream()
        .map(GrupoPesquisaMapper::toDTO).toList();

        return gruposPesquisaDTOs;
    }

    // Salvar cadastro do Grupo de Pesquisa no Banco de Dados
    public GrupoPesquisaDTO cadastrarGrupoPesquisa(RequisicaoGrupoPesquisaDTO requisicaoGrupoPesquisaDTO){
        if(gruposPesquisaRepository.existsByNomeGrupo(requisicaoGrupoPesquisaDTO.getNomeGrupo())){
            throw new NomeGrupoExistenteException("Um Grupo com esse nome já existe" + requisicaoGrupoPesquisaDTO.getNomeGrupo());
        }

        GrupoPesquisa novoGrupoPesquisa = gruposPesquisaRepository.save(
            GrupoPesquisaMapper.toModel(requisicaoGrupoPesquisaDTO));

        return GrupoPesquisaMapper.toDTO(novoGrupoPesquisa);
    }

    // Salvar pedido de alterações do Grupo de Pesquisa em seu historico de mundanças
    public GrupoPesquisaHistoricoDTO salvarGrupoPesquisaHistorico(UUID id, GrupoPesquisaHistoricoDTO grupoPesquisaHistoricoDTO){

        GrupoPesquisa grupoPesquisa = gruposPesquisaRepository.findById(id).orElseThrow(
            () -> new GrupoPesquisaNaoEncontradoException("Grupo não enconrado com ID: " + id));
        
        GrupoPesquisaHistorico grupoPesquisaHistorico = new GrupoPesquisaHistorico();

        grupoPesquisaHistorico.setGrupo(grupoPesquisa);
        grupoPesquisaHistorico.setAlteradoPor(grupoPesquisaHistoricoDTO.getAlteradoPor());
        grupoPesquisaHistorico.setMotivoAlteracao(grupoPesquisaHistoricoDTO.getMotivoAlteracao());
        grupoPesquisaHistorico.setDataAlteracao(LocalDateTime.now());

        try {
            String jsonAlteracoes = objectMapper.writeValueAsString(grupoPesquisaHistoricoDTO.getAlteracoes());
            grupoPesquisaHistorico.setAlteracoes(jsonAlteracoes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao coverter alterações para JSON", e);
        }
        
        GrupoPesquisaHistorico historicoGrupoPesquisa = grupoPesquisaHistoricoRepository.save(grupoPesquisaHistorico);
        return GrupoPesquisaHistoricoMapper.toDTO(historicoGrupoPesquisa);
    }

    public GrupoPesquisaDTO aplicarAlteracoes(UUID id, GrupoPesquisaHistoricoDTO grupoPesquisaHistoricoDTO){

        GrupoPesquisa grupoPesquisa = gruposPesquisaRepository.findById(id).orElseThrow(
            () -> new GrupoPesquisaNaoEncontradoException("Grupo não enconrado com ID: " + id));
        
            
        Map<String, GrupoPesquisaHistoricoDTO.AlteracaoCampo> alteracoes = grupoPesquisaHistoricoDTO.getAlteracoes();

        // Aplica cada alteração no grupo
        alteracoes.forEach((campo, alt) -> aplicarCampo(grupoPesquisa, campo, alt.getDepois()));
        
        // Salva o grupo atualizado
        GrupoPesquisa grupoPesquisaAtualizado = gruposPesquisaRepository.save(grupoPesquisa);
        return GrupoPesquisaMapper.toDTO(grupoPesquisaAtualizado);
    }

    // Iniciar processo de Tramitação de Cadastro do Grupo de Pesquisa
    public ResponseEntity<?> iniciarTramitacaoCadastro(GrupoPesquisaDTO grupoPesquisaDTO){
        try {
            // Iniciar tramitação no Zeebe com ID do Processo e do Grupo
            var result = zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId("cadastro-grupo-pesquisa")
                    .latestVersion()
                    .variables(Map.of("Id", grupoPesquisaDTO.getId().toString()))
                    .send()
                    .join();

            return ResponseEntity.ok(Map.of(
                    "message", "Processo iniciado com sucesso.",
                    "grupoId", grupoPesquisaDTO.getId(),
                    "processInstanceKey", result.getProcessInstanceKey()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao iniciar processo: " + e.getMessage());
        }
    }

    // Iniciar processo de Tramitação de Alteração do Grupo de Pesquisa
    public ResponseEntity<?> iniciarTramitacaoAlteracao(GrupoPesquisaHistoricoDTO grupoPesquisaHistoricoDTO){
        try {
            // Iniciar tramitação no Zeebe com ID do Processo e do Grupo
            var result = zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId("alterar-grupos-pesquisa")
                    .latestVersion()
                    .variables(Map.of("Id", grupoPesquisaHistoricoDTO.getId().toString()))
                    .send()
                    .join();

            return ResponseEntity.ok(Map.of(
                    "message", "Processo iniciado com sucesso.",
                    "grupoId", grupoPesquisaHistoricoDTO.getId(),
                    "processInstanceKey", result.getProcessInstanceKey()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao iniciar processo: " + e.getMessage());
        }
    }

    // Helpers
    private void aplicarCampo(GrupoPesquisa grupo, String campo, Object valorNovo) {
        switch (campo) {

            // --- Dados gerais ---
            case "nomeGrupo":
                grupo.setNomeGrupo((String) valorNovo);
                break;

            // --- Líder ---
            case "nomeLider":
                grupo.setNomeLider((String) valorNovo);
                break;

            case "centroLider":
                grupo.setCentroLider((String) valorNovo);
                break;

            case "emailLider":
                grupo.setEmailLider((String) valorNovo);
                break;

            // --- Vice-líder ---
            case "nomeViceLider":
                grupo.setNomeViceLider((String) valorNovo);
                break;

            case "centroViceLider":
                grupo.setCentroViceLider((String) valorNovo);
                break;

            case "emailViceLider":
                grupo.setEmailViceLider((String) valorNovo);
                break;

            // --- Grande área / área / subárea ---
            case "codigoGrandeArea":
                grupo.setCodigoGrandeArea((String) valorNovo);
                break;

            case "codigoArea":
                grupo.setCodigoArea((String) valorNovo);
                break;

            case "codigoSubArea":
                grupo.setCodigoSubArea((String) valorNovo);
                break;

            case "grandeArea":
                grupo.setGrandeArea((String) valorNovo);
                break;

            case "area":
                grupo.setArea((String) valorNovo);
                break;

            case "subArea":
                grupo.setSubArea((String) valorNovo);
                break;

            // --- Outros dados ---
            case "linhasPesquisa":
                grupo.setLinhasPesquisa((String) valorNovo);
                break;

            case "objetivos":
                grupo.setObjetivos((String) valorNovo);
                break;

            // --- Datas ---
            case "dataInicio":
                grupo.setDataInicio(LocalDate.parse(valorNovo.toString()));
                break;

            case "dataTermino":
                grupo.setDataTermino(LocalDate.parse(valorNovo.toString()));
                break;

            // Caso nenhum campo seja reconhecido
            default:
                throw new IllegalArgumentException("Campo não reconhecido: " + campo);
        }
    }

}

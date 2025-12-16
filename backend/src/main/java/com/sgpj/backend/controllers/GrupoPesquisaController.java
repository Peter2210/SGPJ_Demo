package com.sgpj.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpj.backend.dto.GrupoPesquisaDTO;
import com.sgpj.backend.dto.GrupoPesquisaHistoricoDTO;
import com.sgpj.backend.dto.RequisicaoGrupoPesquisaDTO;
import com.sgpj.backend.service.GrupoPesquisaService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/gruposPesquisa")  // http://localhost:8081/gruposPesquisa
public class GrupoPesquisaController {
    private final GrupoPesquisaService grupoPesquisaService;

    public GrupoPesquisaController(GrupoPesquisaService grupoPesquisaService) {
        this.grupoPesquisaService = grupoPesquisaService;
    }

    @GetMapping
    public ResponseEntity<List<GrupoPesquisaDTO>> getGruposPesquisa(){
        List<GrupoPesquisaDTO> grupos = grupoPesquisaService.getGruposPesquisa();
        return ResponseEntity.ok().body(grupos);
    }

    @PostMapping
    public ResponseEntity<GrupoPesquisaDTO> cadastrarGrupoPesquisa(
        @Valid @RequestBody RequisicaoGrupoPesquisaDTO requisicaoGrupoPesquisaDTO){
             
        GrupoPesquisaDTO grupoPesquisaDTO = grupoPesquisaService.cadastrarGrupoPesquisa(requisicaoGrupoPesquisaDTO);

        grupoPesquisaService.iniciarTramitacaoCadastro(grupoPesquisaDTO);
        
        return ResponseEntity.ok().body(grupoPesquisaDTO);
    }

    // http://localhost:8081/gruposPesquisa/12312312-123123123-12312312
    @PutMapping("/{id}")
    public ResponseEntity<GrupoPesquisaDTO> atualizarGrupoPesquisa(@PathVariable UUID id,
        @RequestBody GrupoPesquisaHistoricoDTO historicoGrupoDTO){

        // Salva o histórico de alterações (pré-aprovação)
        GrupoPesquisaHistoricoDTO grupoPesquisaHistoricoDTO = grupoPesquisaService.salvarGrupoPesquisaHistorico(id, historicoGrupoDTO);

        // Iniciar tramitação
        //grupoPesquisaService.iniciarTramitacaoAlteracao(grupoPesquisaHistoricoDTO);

        // Aplicar alterações aprovadas ao grupo (pós-tramitação/aprovação)
        GrupoPesquisaDTO grupoPesquisaDTO = grupoPesquisaService.aplicarAlteracoes(id, grupoPesquisaHistoricoDTO); 
         
        // Retorna o DTO atualizado
        return ResponseEntity.ok().body(grupoPesquisaDTO);
    }
}

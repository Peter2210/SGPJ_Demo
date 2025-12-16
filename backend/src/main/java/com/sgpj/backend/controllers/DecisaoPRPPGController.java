package com.sgpj.backend.controllers;
import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.model.GrupoPesquisa;
import com.sgpj.backend.model.ProjetoPesquisa;
import com.sgpj.backend.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.repository.RepositorioProjetoPesquisa;

import io.camunda.zeebe.client.ZeebeClient;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/prppg")
public class DecisaoPRPPGController {

    private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioProjetoPesquisa projetosPesquisarRepository;
    private final ZeebeClient zeebeClient;

    public DecisaoPRPPGController(RepositorioGrupoPesquisa grupoRepository, RepositorioProjetoPesquisa projetoRepository,ZeebeClient zeebeClient) {
        this.gruposPesquisaRepository = grupoRepository;
        this.projetosPesquisarRepository = projetoRepository;
        this.zeebeClient = zeebeClient;
    }

    @PostMapping("/gruposPesq/decisoes")
    public ResponseEntity<?> decisaoGrupo(HttpServletRequest request, @RequestBody Map<String, Object> body) {
        UUID id = UUID.fromString(body.get("id").toString());
        Optional<GrupoPesquisa> optionalGrupo = gruposPesquisaRepository.findById(id);
        if (optionalGrupo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        boolean aprovado = Boolean.TRUE.equals(body.get("aprovado"));
        GrupoPesquisa grupo = optionalGrupo.get();

        grupo.setEstadoAtual(Estados.Parado);
        gruposPesquisaRepository.save(grupo);

        zeebeClient.newPublishMessageCommand()
            .messageName("Aprovado")
            .correlationKey(id.toString())
            .variables(Map.of("Aprovado", aprovado))
            .send()
            .join();

        return ResponseEntity.ok(Map.of("message", "Grupo aprovado com sucesso!"));
    }

     @PostMapping("/projetosPesq/decisoes")
    public ResponseEntity<?> decisaoProjeto(HttpServletRequest request, @RequestBody Map<String, Object> body) {
        UUID id = UUID.fromString(body.get("id").toString());
        Optional<ProjetoPesquisa> optionalProjeto = projetosPesquisarRepository.findById(id);
        if (optionalProjeto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        boolean aprovado = Boolean.TRUE.equals(body.get("aprovado"));
        ProjetoPesquisa projeto = optionalProjeto.get();

        projeto.setEstadoAtual(Estados.Parado);
        projetosPesquisarRepository.save(projeto);

        zeebeClient.newPublishMessageCommand()
            .messageName("Aprovado")
            .correlationKey(id.toString())
            .variables(Map.of("Aprovado", aprovado))
            .send()
            .join();

        return ResponseEntity.ok(Map.of("message", "Projeto aprovado com sucesso!"));
    }
}

package com.sgpj.backend.controllers;

import com.sgpj.backend.constants.SgpjEstados.Estados;
//import com.sgpj.backend.dto.GrupoPesquisaDTO;
import com.sgpj.backend.dto.ProjetoPesquisaDTO;
import com.sgpj.backend.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.repository.RepositorioProjetoPesquisa;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/prppg")
public class ConsultaPRPPGController {

    //private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioProjetoPesquisa projetosPesquisaRepository;

    public ConsultaPRPPGController(RepositorioGrupoPesquisa gruposRepository, RepositorioProjetoPesquisa projetosRepository) {
        //this.gruposPesquisaRepository = gruposRepository;
        this.projetosPesquisaRepository = projetosRepository;
    }

    /* 
    // Mapeamento para aprovações relacionadas aos Grupos de Pesquisa
    @GetMapping("/gruposPesq/aprovacoes")
    public List<GrupoPesquisaDTO> listarGruposPorEstado(@RequestParam Estados estado) {
        return gruposPesquisaRepository.findByEstadoAtual(estado)
                .stream()
                .map(GrupoPesquisaDTO::fromEntity)
                .toList();
    }
    */
   
    // Mapeamento para aprovaçções relacionadas aos Projetos de Pesquisa
    @GetMapping("/projetosPesq/aprovacoes")
    public List<ProjetoPesquisaDTO> listarProjetosPorEstado(@RequestParam Estados estado) {
        switch (estado) {
            case Estados.Aprovacao_ComiteEticaAnimal:
                return projetosPesquisaRepository.findByEnvolveEticaAnimal(true)
                    .stream()
                    .map(ProjetoPesquisaDTO::fromEntity)
                    .toList();
                    
            case Estados.Aprovacao_ComiteEticaHumano:
                return projetosPesquisaRepository.findByEnvolveEticaHumana(true)
                    .stream()
                    .map(ProjetoPesquisaDTO::fromEntity)
                    .toList();
        
            default:
                return projetosPesquisaRepository.findByEstadoAtual(estado)
                    .stream()
                    .map(ProjetoPesquisaDTO::fromEntity)
                    .toList();
        } 
    }
}

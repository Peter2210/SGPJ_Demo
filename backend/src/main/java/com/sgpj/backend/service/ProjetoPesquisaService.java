package com.sgpj.backend.service;


import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sgpj.backend.model.GrupoPesquisa;
import com.sgpj.backend.model.ProjetoPesquisa;
import com.sgpj.backend.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.repository.RepositorioProjetoPesquisa;

@Service
public class ProjetoPesquisaService {
    /* 
    private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioProjetoPesquisa projetosRepository;

    public ProjetoPesquisaService(RepositorioGrupoPesquisa gruposPesquisaRepository, RepositorioProjetoPesquisa projetosRepository) {
        this.gruposPesquisaRepository = gruposPesquisaRepository;
        this.projetosRepository = projetosRepository;
    }

    public ProjetoPesquisa salvarProjetoPesquisa(Map<String, Object> formData){
        ProjetoPesquisa projeto = new ProjetoPesquisa();

        projeto.setTitulo((String) formData.get("tituloProjeto"));

        if ((boolean) formData.get("vinculadoGrupoPesquisa")){
            GrupoPesquisa grupo = gruposPesquisaRepository.findByNomeGrupo((String) formData.get("qualGrupoPesquisa"));
            projeto.setGrupo(grupo);
        }

        projeto.setInicioVigencia(LocalDate.parse((String) formData.get("vigenciaInicio")));
        projeto.setFinalizacaoVigencia(LocalDate.parse((String) formData.get("vigenciaFim")));
        projeto.setResumo((String) formData.get("resumo"));
        projeto.setObjetivos((String) formData.get("odsSelecionados"));
        projeto.setPalavrasChaves((String) formData.get("palavrasChave"));
        projeto.setGrandeArea((String) formData.get("grandeArea"));
        projeto.setGrandeAreaCnpq((String) formData.get("codigoGrandeArea"));
        projeto.setArea((String) formData.get("area"));
        projeto.setAreaCnpq((String) formData.get("codigoArea"));
        projeto.setSubArea((String) formData.get("subarea"));
        projeto.setSubAreaCnpq((String) formData.get("codigoSubarea"));

        projeto.setDescricaoProjeto((String) formData.get("descricaoProjeto"));

        projeto.setEnvolveEticaHumana((boolean) formData.get("envolveEticaHumana"));
        projeto.setEnvolveEticaAnimal((boolean) formData.get("envolveEticaAnimal"));
        projeto.setEnvolveSISGEN((boolean) formData.get("envolveSISGEN"));
        projeto.setFinanciamento(false);

        return projetosRepository.save(projeto);
    } 
    */
}

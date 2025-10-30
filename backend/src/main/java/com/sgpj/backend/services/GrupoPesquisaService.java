package com.sgpj.backend.services;

import com.sgpj.backend.mssql.model.GruposPesquisa;
import com.sgpj.backend.mssql.model.Pesquisadores;
import com.sgpj.backend.mssql.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.mssql.repository.RepositorioPesquisadores;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GrupoPesquisaService {

    private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioPesquisadores pesquisadoresRepository;

    public GrupoPesquisaService(RepositorioGrupoPesquisa gruposPesquisaRepository, RepositorioPesquisadores pesquisadoresRepository) {
        this.gruposPesquisaRepository = gruposPesquisaRepository;
        this.pesquisadoresRepository = pesquisadoresRepository;
    }

    public GruposPesquisa salvarGrupoAPartirDoForm(Map<String, Object> formData) {

        GruposPesquisa grupo = new GruposPesquisa();
        grupo.setNomeGrupo((String) formData.get("nomeGrupo"));
        grupo.setNomeLider((String) formData.get("nomeLider"));
        grupo.setCentroLider((String) formData.get("centroLider"));
        grupo.setEmailLider((String) formData.get("emailLider"));
        grupo.setNomeViceLider((String) formData.get("nomeViceLider"));
        grupo.setCentroViceLider((String) formData.get("centroViceLider"));
        grupo.setEmailViceLider((String) formData.get("emailViceLider"));

        grupo.setGrandeArea((String) formData.get("grandeArea"));
        grupo.setCodigoGrandeArea((String) formData.get("codigoGrandeArea"));
        grupo.setArea((String) formData.get("area"));
        grupo.setCodigoArea((String) formData.get("codigoArea"));
        grupo.setSubArea((String) formData.get("subarea"));
        grupo.setCodigoSubArea((String) formData.get("codigoSubarea"));

        grupo.setObjetivos((String) formData.get("objetivos"));
        grupo.setLinhasPesquisa((String) formData.get("linhasPesquisa"));

        // Lista de pesquisadores
        Object pesquisadoresObj = formData.get("pesquisadores");
        if (!(pesquisadoresObj instanceof List<?> listaBruta)) {
            throw new IllegalArgumentException("Lista de pesquisadores inválida.");
        }

        List<Pesquisadores> pesquisadores = new ArrayList<>();
        for (Object o : listaBruta) {
            if (o instanceof Map<?, ?> pMap) {
                Pesquisadores pesquisador = new Pesquisadores();
                pesquisador.setNome((String) pMap.get("nome"));
                pesquisador.setCentroOuInstituicao((String) pMap.get("centroInstituicao"));
                pesquisador.setTipoParticipacao((String) pMap.get("tipo"));
                pesquisador.setGrupo(grupo); // vincula ao grupo
                pesquisadores.add(pesquisador);
            }
        }

        grupo.setPesquisadores(pesquisadores);

        return gruposPesquisaRepository.save(grupo);
    }

    public void adicionarPesquisador(Map<String, Object> formData){

        GruposPesquisa grupo = new GruposPesquisa();

        Object pesquisadoresObj = formData.get("pesquisadores");
        if (!(pesquisadoresObj instanceof List<?> listaBruta)) {
            throw new IllegalArgumentException("Lista de pesquisadores inválida.");
        }

        List<Pesquisadores> pesquisadores = new ArrayList<>();
        for (Object o : listaBruta) {
            if (o instanceof Map<?, ?> pMap) {
                Pesquisadores pesquisador = new Pesquisadores();
                pesquisador.setNome((String) pMap.get("nome"));
                pesquisador.setCentroOuInstituicao((String) pMap.get("centroInstituicao"));
                pesquisador.setTipoParticipacao((String) pMap.get("tipo"));
                pesquisador.setGrupo(grupo);
                pesquisadores.add(pesquisador);
            }
        }
        gruposPesquisaRepository.save(grupo);
    }

    public void retirarPesquisadores(UUID grupoId, String nome){
        Pesquisadores pesquisador = pesquisadoresRepository.findByGrupoIdAndNome(grupoId, nome);
        pesquisadoresRepository.delete(pesquisador);
    }
}

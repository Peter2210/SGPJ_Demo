package com.sgpj.backend.workers;
import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.mssql.model.GruposPesquisa;
import com.sgpj.backend.mssql.model.ProjetosPesquisa;
import com.sgpj.backend.mssql.repository.RepositorioGrupoPesquisa;
import com.sgpj.backend.mssql.repository.RepositorioProjetoPesquisa;

import java.util.*;

import org.springframework.stereotype.Component;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;


@Component
public class AdicionarPendenciasWorker {
    private final RepositorioGrupoPesquisa gruposPesquisaRepository;
    private final RepositorioProjetoPesquisa projetosPesquisaRepository;


    public AdicionarPendenciasWorker(RepositorioGrupoPesquisa gruposPesquisaRepository, RepositorioProjetoPesquisa projetosPesquisaRepository) {
        this.gruposPesquisaRepository = gruposPesquisaRepository;
        this.projetosPesquisaRepository = projetosPesquisaRepository;
    }

    @JobWorker(type = "adicionar-pendencias-aprovacao")
    public void adicionarPendecias(@Variable(name = "TipoProcesso") String tipoProcesso, @Variable(name = "Id") UUID Id, @Variable(name = "Estado") String Estado) {

        switch (tipoProcesso) {
            case "CadastroProjeto":
                dependenciaCadastroProjetoPesquisa(Id, Estado);
                break;
            case "CadastroGrupo":
                dependenciaCadastroGrupoPesquisa(Id, Estado);
                break;
            // Adicionar mais processos necessários
            default:
                throw new IllegalArgumentException("Tipo de processo desconhecido: " + tipoProcesso);
        }
        
    }

    public void dependenciaCadastroGrupoPesquisa(UUID Id, String Estado){
        Optional<GruposPesquisa> optionalGrupo = gruposPesquisaRepository.findById(Id);
        GruposPesquisa grupo = optionalGrupo.get();
        grupo.setEstadoAtual(Estados.valueOf(Estado));
        gruposPesquisaRepository.save(grupo);
    }

    public void dependenciaCadastroProjetoPesquisa(UUID Id, String Estado){
        Optional<ProjetosPesquisa> optionalProjeto = projetosPesquisaRepository.findById(Id);
        ProjetosPesquisa projeto = optionalProjeto.get();
        projeto.setEstadoAtual(Estados.valueOf(Estado));
        projetosPesquisaRepository.save(projeto);
    }
}
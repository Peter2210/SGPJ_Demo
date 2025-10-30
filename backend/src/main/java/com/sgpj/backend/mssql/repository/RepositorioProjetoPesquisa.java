package com.sgpj.backend.mssql.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.mssql.model.GruposPesquisa;
import com.sgpj.backend.mssql.model.ProjetosPesquisa;

import java.util.*;


public interface RepositorioProjetoPesquisa extends JpaRepository<ProjetosPesquisa, UUID>{
    Optional<ProjetosPesquisa> findById(UUID id);

    List<ProjetosPesquisa> findByGrupo(GruposPesquisa grupo);

    List<ProjetosPesquisa> findByEstadoAtual(Estados estado);
}

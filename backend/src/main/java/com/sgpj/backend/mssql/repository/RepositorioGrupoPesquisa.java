package com.sgpj.backend.mssql.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.mssql.model.GruposPesquisa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioGrupoPesquisa extends JpaRepository<GruposPesquisa, UUID> {

    List<GruposPesquisa> findByEstadoAtual(Estados estado);

    List<GruposPesquisa> findByAtivoTrue();

    List<GruposPesquisa> findByAtivoFalse();

    Optional<GruposPesquisa> findById(UUID id); // já vem do JpaRepository, pode omitir

    GruposPesquisa findByNomeGrupo(String nomeGrupo);

    List<GruposPesquisa> findByNomeLider(String nomeLider);
}

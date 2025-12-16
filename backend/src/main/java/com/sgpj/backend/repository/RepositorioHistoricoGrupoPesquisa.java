package com.sgpj.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sgpj.backend.model.GrupoPesquisaHistorico;

@Repository
public interface RepositorioHistoricoGrupoPesquisa extends JpaRepository<GrupoPesquisaHistorico, UUID>{
}

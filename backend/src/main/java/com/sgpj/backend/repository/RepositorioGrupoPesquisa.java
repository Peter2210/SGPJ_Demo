package com.sgpj.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.model.GrupoPesquisa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioGrupoPesquisa extends JpaRepository<GrupoPesquisa, UUID> {

    // Lógicas de Negócio 
    boolean existsByNomeGrupo(String nomeGrupo);
    
    List<GrupoPesquisa> findByEstadoAtual(Estados estado);

    List<GrupoPesquisa> findByAtivoTrue();

    List<GrupoPesquisa> findByAtivoFalse();

    Optional<GrupoPesquisa> findById(UUID id);

    GrupoPesquisa findByNomeGrupo(String nomeGrupo);

    List<GrupoPesquisa> findByNomeLider(String nomeLider);
}

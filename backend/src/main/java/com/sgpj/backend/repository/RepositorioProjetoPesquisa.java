package com.sgpj.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sgpj.backend.constants.SgpjEstados.Estados;
import com.sgpj.backend.model.GrupoPesquisa;
import com.sgpj.backend.model.ProjetoPesquisa;

import java.util.*;


public interface RepositorioProjetoPesquisa extends JpaRepository<ProjetoPesquisa, UUID>{
    Optional<ProjetoPesquisa> findById(UUID id);

    List<ProjetoPesquisa> findByGrupo(GrupoPesquisa grupo);

    List<ProjetoPesquisa> findByEnvolveEticaHumana(boolean necessidade);

    List<ProjetoPesquisa> findByEnvolveEticaAnimal(boolean necessidade);

    List<ProjetoPesquisa> findByEstadoAtual(Estados estado);
}

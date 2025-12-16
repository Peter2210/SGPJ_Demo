package com.sgpj.backend.repository;

import com.sgpj.backend.model.Pesquisador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioPesquisadores extends JpaRepository<Pesquisador, UUID> {

    Optional<Pesquisador> findById(UUID id);

    List<Pesquisador> findByNome(String nome);

    List<Pesquisador> findByCentroOuInstituicao(String nome);

    List<Pesquisador> findByTipoParticipacao(String nome);

    List<Pesquisador> findByGrupoId(UUID grupoId);

    Pesquisador findByGrupoIdAndNome(UUID grupoId, String nome);
}

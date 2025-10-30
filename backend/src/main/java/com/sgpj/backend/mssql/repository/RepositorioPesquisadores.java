package com.sgpj.backend.mssql.repository;

import com.sgpj.backend.mssql.model.Pesquisadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioPesquisadores extends JpaRepository<Pesquisadores, UUID> {

    // Este já é herdado do JpaRepository, mas pode ser mantido se quiser personalizar retorno
    Optional<Pesquisadores> findById(UUID id);

    List<Pesquisadores> findByNome(String nome);

    List<Pesquisadores> findByCentroOuInstituicao(String nome);

    List<Pesquisadores> findByTipoParticipacao(String nome);

    List<Pesquisadores> findByGrupoId(UUID grupoId);

    Pesquisadores findByGrupoIdAndNome(UUID grupoId, String nome);
}

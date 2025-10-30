package com.sgpj.backend.dto;

import com.sgpj.backend.mssql.model.GruposPesquisa;

import java.time.LocalDateTime;
import java.util.UUID;

public record GrupoPesquisaDTO(
        UUID id,
        String nomeGrupo,
        String nomeLider,
        LocalDateTime dataCriacao
) {
    public static GrupoPesquisaDTO fromEntity(GruposPesquisa grupo) {
        return new GrupoPesquisaDTO(
                grupo.getId(),
                grupo.getNomeGrupo(),
                grupo.getNomeLider(),
                grupo.getDataCriacao()
        );
    }
}

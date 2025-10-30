package com.sgpj.backend.dto;

import com.sgpj.backend.mssql.model.ProjetosPesquisa;

import java.util.UUID;

public record ProjetoPesquisaDTO(
        UUID id,
        String titulo,
        String grupo,
        String descricaoProjeto
) {
    public static ProjetoPesquisaDTO fromEntity(ProjetosPesquisa projeto) {
        return new ProjetoPesquisaDTO(
                projeto.getId(),
                projeto.getTitulo(),
                projeto.getGrupo().getNomeGrupo(),
                projeto.getDescricaoProjeto()
        );
    }
}
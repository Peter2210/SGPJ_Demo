package com.sgpj.backend.dto;

//import com.sgpj.backend.model.GrupoPesquisa;
import com.sgpj.backend.model.ProjetoPesquisa;

import java.util.UUID;

public record ProjetoPesquisaDTO(
        UUID id,
        String tituloProjeto,
        String nomeGrupo,
        String descricaoProjeto
) {
    public static ProjetoPesquisaDTO fromEntity(ProjetoPesquisa projeto) {
        //GrupoPesquisa grupo = projeto.getGrupo();
        String nome = "Nenhum";
        //if(grupo != null){
        //    nome = "Nenhum";
        // }
        return new ProjetoPesquisaDTO(
                projeto.getId(),
                projeto.getTitulo(),
                nome,
                projeto.getDescricaoProjeto()
        );
    }
}
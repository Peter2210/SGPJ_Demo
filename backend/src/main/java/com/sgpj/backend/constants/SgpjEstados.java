package com.sgpj.backend.constants;

public class SgpjEstados {
    public enum Estados {
        Parado,
        Aprovacao_ComiteEticaHumana,
        Aprovacao_ComiteEticaAnimal,
        Aprovacao_ComissaoPesquisa,
        Aprovacao_ConselhoCentro,
        Aprovacao_ConselhoCampus,
        Aprovacao_PRPPG,
        Aprovacao_PROEX,
        Aprovacao_PROGRAD,
        Correcao,
        Desistido,
        Reprovado,
        Aprovado,

        Ativo,
        Alteracao_ComiteEtica,
        Alteracao_ComissaoPesquisa,
        Alteracao_ConselhoCentro,
        Alteracao_PRPPG,
        Alteracao_PROEX,
        Alteracao_PROGRAD,

        Finalizado,
        Cancelado
    }
}

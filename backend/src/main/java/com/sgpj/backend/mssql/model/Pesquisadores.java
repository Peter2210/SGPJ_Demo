package com.sgpj.backend.mssql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Pesquisadores")
@Data
public class Pesquisadores {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String nome;
    private String centroOuInstituicao;
    private String tipoParticipacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GrupoId")
    private GruposPesquisa grupo;
}

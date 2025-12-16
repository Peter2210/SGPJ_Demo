package com.sgpj.backend.model;

import jakarta.persistence.*;

import java.util.UUID;

import io.micrometer.common.lang.NonNull;

@Entity
@Table(name = "Pesquisadores")
public class Pesquisador {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @NonNull
    private String nome;

    @NonNull
    private String centroOuInstituicao;

    @NonNull
    private String tipoParticipacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GrupoId")
    private GrupoPesquisa grupo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NonNull String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public @NonNull String getCentroOuInstituicao() {
        return centroOuInstituicao;
    }

    public void setCentroOuInstituicao(@NonNull String centroOuInstituicao) {
        this.centroOuInstituicao = centroOuInstituicao;
    }

    public @NonNull String getTipoParticipacao() {
        return tipoParticipacao;
    }

    public void setTipoParticipacao(@NonNull String tipoParticipacao) {
        this.tipoParticipacao = tipoParticipacao;
    }

    public GrupoPesquisa getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPesquisa grupo) {
        this.grupo = grupo;
    }
}

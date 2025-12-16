package com.sgpj.backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Parecer")
@Data
public class Parecer {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @NonNull
    private String entidade;

    @NonNull
    private boolean aprovado;

    @NonNull
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GrupoId")
    private GrupoPesquisa grupo;

    public @NonNull UUID getId() {
        return id;
    }

    public void setId(@NonNull UUID id) {
        this.id = id;
    }

    public @NonNull String getEntidade() {
        return entidade;
    }

    public void setEntidade(@NonNull String entidade) {
        this.entidade = entidade;
    }

    public @NonNull boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(@NonNull boolean aprovado) {
        this.aprovado = aprovado;
    }

    public @NonNull LocalDateTime getData() {
        return data;
    }

    public void setData(@NonNull LocalDateTime data) {
        this.data = data;
    }

    public GrupoPesquisa getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPesquisa grupo) {
        this.grupo = grupo;
    }

}

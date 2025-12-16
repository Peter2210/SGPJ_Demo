package com.sgpj.backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "GrupoPesquisaHistorico")
public class GrupoPesquisaHistorico {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", nullable = false)
    private GrupoPesquisa grupo;

    @Column(nullable = true)
    private String alteradoPor;

    @Column(nullable = false)
    private LocalDateTime dataAlteracao = LocalDateTime.now();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String alteracoes;  // JSON contendo todas as mudanças

    /*
    JSON exemplo de 'alteracoes'
    {
    "nomeLider": { "antes": "João", "depois": "João Silva" },
    "objetivos": { "antes": "Estudar IA", "depois": "Desenvolver IA aplicada" },
    "ativo": { "antes": false, "depois": true }
    }
    */

    @Column(columnDefinition = "TEXT")
    private String motivoAlteracao;

    // GETTERS & SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GrupoPesquisa getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPesquisa grupo) {
        this.grupo = grupo;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(String alteracoes) {
        this.alteracoes = alteracoes;
    }

    public String getMotivoAlteracao() {
        return motivoAlteracao;
    }

    public void setMotivoAlteracao(String motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }
}

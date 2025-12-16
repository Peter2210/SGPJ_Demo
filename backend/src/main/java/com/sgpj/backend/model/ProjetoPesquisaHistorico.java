package com.sgpj.backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "ProjetoPesquisa_Historico")
public class ProjetoPesquisaHistorico {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoPesquisa projeto;

    @Column(nullable = true)
    private String alteradoPor;

    @Column(nullable = false)
    private LocalDateTime dataAlteracao = LocalDateTime.now();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String alteracoes; // JSON contendo todas as mudanças

    @Column(columnDefinition = "TEXT")
    private String motivoAlteracao;

    // GETTERS E SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProjetoPesquisa getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoPesquisa projeto) {
        this.projeto = projeto;
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

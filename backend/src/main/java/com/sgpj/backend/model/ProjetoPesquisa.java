package com.sgpj.backend.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.sgpj.backend.constants.SgpjEstados.Estados;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

@Entity
@Table(name = "ProjetosPesquisa")
public class ProjetoPesquisa {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @NonNull
    private String titulo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Projeto_Grupo",
        joinColumns = @JoinColumn(name = "ProjetoId"),
        inverseJoinColumns = @JoinColumn(name = "GrupoId")
    )
    private List<GrupoPesquisa> grupo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicioVigencia;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate finalizacaoVigencia;

    @NonNull
    private String resumo;

    @NonNull
    private String objetivos;

    @NonNull
    private String palavrasChaves;

    @NonNull
    private String grandeArea;

    @NonNull
    private String grandeAreaCnpq;

    @NonNull
    private String area;

    @NonNull
    private String areaCnpq;

    @NonNull
    private String subArea;

    @NonNull
    private String subAreaCnpq;

    @NonNull
    private String descricaoProjeto;

    @NonNull
    @Column(nullable = false)
    private boolean envolveEticaHumana = false;

    @NonNull
    @Column(nullable = false)
    private boolean envolveEticaAnimal = false;

    @NonNull
    @Column(nullable = false)
    private boolean envolveSISGEN = false;

    @NonNull
    @Column(nullable = false)
    private boolean financiamento = false;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estados estadoAtual = Estados.Parado;

    @Column(nullable = false)
    private boolean ativo = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NonNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    public List<GrupoPesquisa> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<GrupoPesquisa> grupo) {
        this.grupo = grupo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFinalizacaoVigencia() {
        return finalizacaoVigencia;
    }

    public void setFinalizacaoVigencia(LocalDate finalizacaoVigencia) {
        this.finalizacaoVigencia = finalizacaoVigencia;
    }

    public @NonNull String getResumo() {
        return resumo;
    }

    public void setResumo(@NonNull String resumo) {
        this.resumo = resumo;
    }

    public @NonNull String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(@NonNull String objetivos) {
        this.objetivos = objetivos;
    }

    public @NonNull String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(@NonNull String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public @NonNull String getGrandeArea() {
        return grandeArea;
    }

    public void setGrandeArea(@NonNull String grandeArea) {
        this.grandeArea = grandeArea;
    }

    public @NonNull String getGrandeAreaCnpq() {
        return grandeAreaCnpq;
    }

    public void setGrandeAreaCnpq(@NonNull String grandeAreaCnpq) {
        this.grandeAreaCnpq = grandeAreaCnpq;
    }

    public @NonNull String getArea() {
        return area;
    }

    public void setArea(@NonNull String area) {
        this.area = area;
    }

    public @NonNull String getAreaCnpq() {
        return areaCnpq;
    }

    public void setAreaCnpq(@NonNull String areaCnpq) {
        this.areaCnpq = areaCnpq;
    }

    public @NonNull String getSubArea() {
        return subArea;
    }

    public void setSubArea(@NonNull String subArea) {
        this.subArea = subArea;
    }

    public @NonNull String getSubAreaCnpq() {
        return subAreaCnpq;
    }

    public void setSubAreaCnpq(@NonNull String subAreaCnpq) {
        this.subAreaCnpq = subAreaCnpq;
    }

    public @NonNull String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(@NonNull String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    // Booleans
    public boolean getEnvolveEticaHumana() {
        return envolveEticaHumana;
    }

    public void setEnvolveEticaHumana(boolean envolveEticaHumana) {
        this.envolveEticaHumana = envolveEticaHumana;
    }

    public boolean getEnvolveEticaAnimal() {
        return envolveEticaAnimal;
    }

    public void setEnvolveEticaAnimal(boolean envolveEticaAnimal) {
        this.envolveEticaAnimal = envolveEticaAnimal;
    }

    public boolean getEnvolveSISGEN() {
        return envolveSISGEN;
    }

    public void setEnvolveSISGEN(boolean envolveSISGEN) {
        this.envolveSISGEN = envolveSISGEN;
    }

    public boolean getFinanciamento() {
        return financiamento;
    }

    public void setFinanciamento(boolean financiamento) {
        this.financiamento = financiamento;
    }

    public @NonNull Estados getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(@NonNull Estados estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

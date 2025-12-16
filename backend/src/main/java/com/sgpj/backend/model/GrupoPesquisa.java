package com.sgpj.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import com.sgpj.backend.constants.SgpjEstados.Estados;

@Entity
@Table(name = "GrupoPesquisa")
public class GrupoPesquisa {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String nomeGrupo;

    @Column(nullable = false)
    private String nomeLider;

    @Column(nullable = false)
    private String centroLider;

    @Email
    @Column(nullable = false)
    private String emailLider;

    @Column(nullable = false)
    private String nomeViceLider;

    @Column(nullable = false)
    private String centroViceLider;

    @Email
    @Column(nullable = false)
    private String emailViceLider;

    @Column(nullable = false)
    private String grandeArea;

    @Column(nullable = false)
    private String codigoGrandeArea;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false)
    private String codigoArea;

    @Column(nullable = false)
    private String subArea;

    @Column(nullable = false)
    private String codigoSubArea;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String linhasPesquisa;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String objetivos;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estados estadoAtual = Estados.Parado;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dataTermino;

    @Column(nullable = false)
    private boolean ativo = false;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pesquisador> pesquisadores;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parecer> pareceres;

    // =============================
    // Getters e Setters
    // =============================

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
    }

    public String getCentroLider() {
        return centroLider;
    }

    public void setCentroLider(String centroLider) {
        this.centroLider = centroLider;
    }

    public String getEmailLider() {
        return emailLider;
    }

    public void setEmailLider(String emailLider) {
        this.emailLider = emailLider;
    }

    public String getNomeViceLider() {
        return nomeViceLider;
    }

    public void setNomeViceLider(String nomeViceLider) {
        this.nomeViceLider = nomeViceLider;
    }

    public String getCentroViceLider() {
        return centroViceLider;
    }

    public void setCentroViceLider(String centroViceLider) {
        this.centroViceLider = centroViceLider;
    }

    public String getEmailViceLider() {
        return emailViceLider;
    }

    public void setEmailViceLider(String emailViceLider) {
        this.emailViceLider = emailViceLider;
    }

    public String getGrandeArea() {
        return grandeArea;
    }

    public void setGrandeArea(String grandeArea) {
        this.grandeArea = grandeArea;
    }

    public String getCodigoGrandeArea() {
        return codigoGrandeArea;
    }

    public void setCodigoGrandeArea(String codigoGrandeArea) {
        this.codigoGrandeArea = codigoGrandeArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public String getCodigoSubArea() {
        return codigoSubArea;
    }

    public void setCodigoSubArea(String codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }

    public String getLinhasPesquisa() {
        return linhasPesquisa;
    }

    public void setLinhasPesquisa(String linhasPesquisa) {
        this.linhasPesquisa = linhasPesquisa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Estados getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(Estados estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Pesquisador> getPesquisadores() {
        return pesquisadores;
    }

    public void setPesquisadores(List<Pesquisador> pesquisadores) {
        this.pesquisadores = pesquisadores;
    }

    public List<Parecer> getPareceres() {
        return pareceres;
    }

    public void setPareceres(List<Parecer> pareceres) {
        this.pareceres = pareceres;
    }
}

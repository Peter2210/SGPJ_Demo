package com.sgpj.backend.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequisicaoGrupoPesquisaDTO {

    @NotBlank(message = "Nome de Grupo obrigatório")
    @Size(max = 100, message = "")
    private String nomeGrupo;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 100, message = "")
    private String nomeLider;

    @NotBlank(message = "Centro obrigatório")
    private String centroLider;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email deve ser válido")
    private String emailLider;

    @NotBlank(message = "Nome obrigatório")
    private String nomeViceLider;

    @NotBlank(message = "Centro obrigatório")
    private String centroViceLider;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email deve ser válido")
    private String emailViceLider;

    @NotBlank(message = "Área CNPq obrigatório")
    private String grandeArea;

    @NotBlank(message = "Área CNPq obrigatório")
    private String codigoGrandeArea;

    @NotBlank(message = "Área CNPq obrigatório")
    private String area;

    @NotBlank(message = "Área CNPq obrigatório")
    private String codigoArea;

    @NotBlank(message = "Área CNPq obrigatório")
    private String subArea;

    @NotBlank(message = "Área CNPq obrigatório")
    private String codigoSubArea;

    @NotBlank(message = "Linha de Pesquisa obrigatório")
    private String linhasPesquisa;

    @NotBlank(message = "Objetivos obrigatórios")
    private String objetivos;

    @NotNull(message = "Data de início obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataInicio;

    @NotNull(message = "Data de término obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataTermino;

    // Getters and Setters

    public @NotBlank @Size(max = 100) String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(@NotBlank @Size(max = 100) String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public @NotBlank @Size(max = 100) String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(@NotBlank @Size(max = 100) String nomeLider) {
        this.nomeLider = nomeLider;
    }

    public @NotBlank String getCentroLider() {
        return centroLider;
    }

    public void setCentroLider(@NotBlank String centroLider) {
        this.centroLider = centroLider;
    }

    public @NotBlank @Email String getEmailLider() {
        return emailLider;
    }

    public void setEmailLider(@NotBlank @Email String emailLider) {
        this.emailLider = emailLider;
    }

    public @NotBlank String getNomeViceLider() {
        return nomeViceLider;
    }

    public void setNomeViceLider(@NotBlank String nomeViceLider) {
        this.nomeViceLider = nomeViceLider;
    }

    public @NotBlank String getCentroViceLider() {
        return centroViceLider;
    }

    public void setCentroViceLider(@NotBlank String centroViceLider) {
        this.centroViceLider = centroViceLider;
    }

    public @NotBlank @Email String getEmailViceLider() {
        return emailViceLider;
    }

    public void setEmailViceLider(@NotBlank @Email String emailViceLider) {
        this.emailViceLider = emailViceLider;
    }

    public @NotBlank String getGrandeArea() {
        return grandeArea;
    }

    public void setGrandeArea(@NotBlank String grandeArea) {
        this.grandeArea = grandeArea;
    }

    public @NotBlank String getCodigoGrandeArea() {
        return codigoGrandeArea;
    }

    public void setCodigoGrandeArea(@NotBlank String codigoGrandeArea) {
        this.codigoGrandeArea = codigoGrandeArea;
    }

    public @NotBlank String getArea() {
        return area;
    }

    public void setArea(@NotBlank String area) {
        this.area = area;
    }

    public @NotBlank String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(@NotBlank String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public @NotBlank String getSubArea() {
        return subArea;
    }

    public void setSubArea(@NotBlank String subArea) {
        this.subArea = subArea;
    }

    public @NotBlank String getCodigoSubArea() {
        return codigoSubArea;
    }

    public void setCodigoSubArea(@NotBlank String codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }

    public @NotBlank String getLinhasPesquisa() {
        return linhasPesquisa;
    }

    public void setLinhasPesquisa(@NotBlank String linhasPesquisa) {
        this.linhasPesquisa = linhasPesquisa;
    }

    public @NotBlank String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(@NotBlank String objetivos) {
        this.objetivos = objetivos;
    }

    public @NotNull String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NotNull String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public @NotNull String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(@NotNull String dataTermino) {
        this.dataTermino = dataTermino;
    }
}

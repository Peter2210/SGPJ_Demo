package com.sgpj.backend.dto;

public class GrupoPesquisaDTO{
    private String id;
    private String nomeGrupo;
    private String nomeLider;
    private String emailLider;
    private String dataCriacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeLider() {
        return nomeLider;
    }
    
    public String getEmailLider() {
        return emailLider;
    }

    public void setEmailLider(String emailLider) {
        this.emailLider = emailLider;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
    }
}

package com.sgpj.backend.dto;

import java.util.Map;

public class GrupoPesquisaHistoricoDTO {

    private String id;
    private String grupoId;
    private String alteradoPor;
    private String motivoAlteracao;
    private Map<String, AlteracaoCampo> alteracoes;
    private String dataAlteracao;

    // Classe interna representando cada alteração de campo
    public static class AlteracaoCampo {
        private Object antes;
        private Object depois;

        public Object getAntes() {
            return antes;
        }

        public void setAntes(Object antes) {
            this.antes = antes;
        }

        public Object getDepois() {
            return depois;
        }

        public void setDepois(Object depois) {
            this.depois = depois;
        }
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public String getMotivoAlteracao() {
        return motivoAlteracao;
    }

    public void setMotivoAlteracao(String motivoAlteracao) {
        this.motivoAlteracao = motivoAlteracao;
    }

    public Map<String, AlteracaoCampo> getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(Map<String, AlteracaoCampo> alteracoes) {
        this.alteracoes = alteracoes;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}

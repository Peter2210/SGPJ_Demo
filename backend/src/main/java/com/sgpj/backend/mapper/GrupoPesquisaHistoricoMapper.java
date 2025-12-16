package com.sgpj.backend.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgpj.backend.dto.GrupoPesquisaHistoricoDTO;
import com.sgpj.backend.model.GrupoPesquisaHistorico;

import java.util.Map;

public class GrupoPesquisaHistoricoMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static GrupoPesquisaHistoricoDTO toDTO(GrupoPesquisaHistorico historico) {
        GrupoPesquisaHistoricoDTO dto = new GrupoPesquisaHistoricoDTO();

        dto.setId(historico.getId().toString());
        dto.setGrupoId(historico.getGrupo().getId().toString());
        dto.setAlteradoPor(historico.getAlteradoPor());
        dto.setMotivoAlteracao(historico.getMotivoAlteracao());
        dto.setDataAlteracao(historico.getDataAlteracao().toString());

        try {
            // JSON → Map
            Map<String, GrupoPesquisaHistoricoDTO.AlteracaoCampo> alteracoes =
                objectMapper.readValue(
                    historico.getAlteracoes(),
                    new TypeReference<Map<String, GrupoPesquisaHistoricoDTO.AlteracaoCampo>>() {}
                );
            dto.setAlteracoes(alteracoes);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para Map<AlteracaoCampo>", e);
        }

        return dto;
    }

    public static GrupoPesquisaHistorico toModel(GrupoPesquisaHistoricoDTO dto) {
        GrupoPesquisaHistorico historico = new GrupoPesquisaHistorico();
        historico.setAlteradoPor(dto.getAlteradoPor());
        historico.setMotivoAlteracao(dto.getMotivoAlteracao());

        try {
            // Map → JSON
            String json = objectMapper.writeValueAsString(dto.getAlteracoes());
            historico.setAlteracoes(json);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao converter Map<AlteracaoCampo> para JSON", e);
        }

        return historico;
    }
}

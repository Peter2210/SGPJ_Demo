package com.sgpj.backend.mapper;

import java.time.LocalDate;

import com.sgpj.backend.dto.GrupoPesquisaDTO;
import com.sgpj.backend.dto.RequisicaoGrupoPesquisaDTO;
import com.sgpj.backend.model.GrupoPesquisa;

public class GrupoPesquisaMapper {
    public static GrupoPesquisaDTO toDTO(GrupoPesquisa grupoPesquisa){
        GrupoPesquisaDTO grupoDTO = new GrupoPesquisaDTO();
        grupoDTO.setId(grupoPesquisa.getId().toString());
        grupoDTO.setNomeLider(grupoPesquisa.getNomeLider());
        grupoDTO.setEmailLider(grupoPesquisa.getEmailLider());
        grupoDTO.setNomeGrupo(grupoPesquisa.getNomeGrupo());
        grupoDTO.setDataCriacao(grupoPesquisa.getDataCriacao().toString());

        return grupoDTO;
    }

    public static GrupoPesquisa toModel(RequisicaoGrupoPesquisaDTO requisicaoGrupoPesquisaDTO){
        GrupoPesquisa grupoPesquisa = new GrupoPesquisa();
        grupoPesquisa.setNomeGrupo(requisicaoGrupoPesquisaDTO.getNomeGrupo());
        grupoPesquisa.setNomeLider(requisicaoGrupoPesquisaDTO.getNomeLider());
        grupoPesquisa.setCentroLider(requisicaoGrupoPesquisaDTO.getCentroLider());
        grupoPesquisa.setEmailLider(requisicaoGrupoPesquisaDTO.getEmailLider());

        grupoPesquisa.setNomeViceLider(requisicaoGrupoPesquisaDTO.getNomeViceLider());
        grupoPesquisa.setCentroViceLider(requisicaoGrupoPesquisaDTO.getCentroViceLider());
        grupoPesquisa.setEmailViceLider(requisicaoGrupoPesquisaDTO.getEmailViceLider());

        grupoPesquisa.setCodigoGrandeArea(requisicaoGrupoPesquisaDTO.getCodigoGrandeArea());
        grupoPesquisa.setCodigoSubArea(requisicaoGrupoPesquisaDTO.getCodigoSubArea());
        grupoPesquisa.setGrandeArea(requisicaoGrupoPesquisaDTO.getGrandeArea());
        grupoPesquisa.setCodigoArea(requisicaoGrupoPesquisaDTO.getCodigoArea());
        grupoPesquisa.setSubArea(requisicaoGrupoPesquisaDTO.getSubArea());
        grupoPesquisa.setArea(requisicaoGrupoPesquisaDTO.getArea());

        grupoPesquisa.setLinhasPesquisa(requisicaoGrupoPesquisaDTO.getLinhasPesquisa());
        grupoPesquisa.setObjetivos(requisicaoGrupoPesquisaDTO.getObjetivos());
        grupoPesquisa.setDataInicio(LocalDate.parse(requisicaoGrupoPesquisaDTO.getDataInicio()));
        grupoPesquisa.setDataTermino(LocalDate.parse(requisicaoGrupoPesquisaDTO.getDataTermino()));

        return grupoPesquisa;
    }
}

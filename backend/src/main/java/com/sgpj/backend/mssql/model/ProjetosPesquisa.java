package com.sgpj.backend.mssql.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.sgpj.backend.constants.SgpjEstados.Estados;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ProjetosPesquisa")
@Data
public class ProjetosPesquisa {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String titulo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GrupoId")
    private GruposPesquisa grupo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicioVigencia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finalizacaoVigencia;

    private String resumo;

    private String objetivos;

    private String palavrasChaves;

    private String grandeArea;

    private String grandeAreaCnpq;

    private String area;

    private String areaCnpq;

    private String subArea;

    private String subAreaCnpq;

    private String descricaoProjeto;

    @Column(nullable = false)
    private boolean envolveEticaHumana = false;
    public boolean getEnvolveEticaHumana() { return envolveEticaHumana; }
    
    @Column(nullable = false)
    private boolean envolveEticaAnimal = false;
    public boolean getEnvolveEticaAnimal() { return envolveEticaAnimal; }

    @Column(nullable = false)
    private boolean  envolveSISGEN = false;
    public boolean getEnvolveSISGEN() { return envolveSISGEN; }

    @Column(nullable = false)
    private boolean financiamento = false;
    public boolean getFinanciamento() { return financiamento; }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estados estadoAtual = Estados.Parado;

    @Column(nullable = false)
    private boolean ativo = false;
}

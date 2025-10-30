package com.sgpj.backend.mssql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.sgpj.backend.constants.SgpjEstados.Estados;

@Entity
@Table(name = "GruposPesquisa")
@Data
public class GruposPesquisa {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String nomeGrupo;

    private String nomeLider;
    private String centroLider;
    private String emailLider;

    private String nomeViceLider;
    private String centroViceLider;
    private String emailViceLider;

    private String grandeArea;
    private String codigoGrandeArea;

    private String area;
    private String codigoArea;

    private String subArea;
    private String codigoSubArea;

    @Column(columnDefinition = "TEXT")
    private String objetivos;

    @Column(columnDefinition = "TEXT")
    private String linhasPesquisa;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estados estadoAtual = Estados.Parado;

    @Column(nullable = false)
    private boolean ativo = false;


    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pesquisadores> pesquisadores;
}

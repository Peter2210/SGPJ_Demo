CREATE TABLE [Instituicao] (
  [id] uuid PRIMARY KEY,
  [nome] nvarchar(255) NOT NULL,
  [sigla] nvarchar(255),
  [ativo] boolean DEFAULT (true),
  [data_criacao] timestamp
)
GO

CREATE TABLE [Projeto] (
  [id] uuid PRIMARY KEY,
  [instituicao_id] uuid NOT NULL,
  [tipo_projeto] nvarchar(255) NOT NULL,
  [titulo] nvarchar(255) NOT NULL,
  [resumo] text NOT NULL,
  [coordenador] nvarchar(255) NOT NULL,
  [centro] nvarchar(255),
  [campus] nvarchar(255),
  [periodo_inicio] date NOT NULL,
  [periodo_fim] date,
  [status] nvarchar(255) NOT NULL,
  [ativo] boolean DEFAULT (true),
  [data_criacao] timestamp,
  [data_atualizacao] timestamp
)
GO

CREATE TABLE [ProjetoPesquisa] (
  [projeto_id] uuid PRIMARY KEY,
  [grande_area] nvarchar(255),
  [area] nvarchar(255),
  [sub_area] nvarchar(255),
  [envolve_etica_humana] boolean,
  [envolve_etica_animal] boolean,
  [envolve_sisgen] boolean,
  [financiamento] boolean
)
GO

CREATE TABLE [ProjetoEnsino] (
  [projeto_id] uuid PRIMARY KEY,
  [colegiado] nvarchar(255),
  [justificativa] text,
  [fundamentacao] text,
  [metodologia] text,
  [contribuicoes] text
)
GO

CREATE TABLE [ProjetoLiga] (
  [projeto_id] uuid PRIMARY KEY,
  [criterios_avaliacao] text,
  [divulgacao] text
)
GO

CREATE TABLE [Formulario] (
  [id] uuid PRIMARY KEY,
  [instituicao_id] uuid,
  [nome] nvarchar(255) NOT NULL,
  [tipo_projeto] nvarchar(255),
  [descricao] text,
  [ativo] boolean
)
GO

CREATE TABLE [FormularioCampo] (
  [id] uuid PRIMARY KEY,
  [formulario_id] uuid NOT NULL,
  [nome_campo] nvarchar(255) NOT NULL,
  [tipo_dado] nvarchar(255) NOT NULL,
  [obrigatorio] boolean,
  [ordem] int
)
GO

CREATE TABLE [ProjetoFormulario] (
  [id] uuid PRIMARY KEY,
  [projeto_id] uuid NOT NULL,
  [formulario_id] uuid NOT NULL,
  [data_envio] timestamp
)
GO

CREATE TABLE [ProjetoFormularioResposta] (
  [id] uuid PRIMARY KEY,
  [projeto_formulario_id] uuid NOT NULL,
  [campo_id] uuid NOT NULL,
  [valor] text
)
GO

CREATE TABLE [Participante] (
  [id] uuid PRIMARY KEY,
  [projeto_id] uuid NOT NULL,
  [instituicao_id] uuid,
  [tipo] nvarchar(255) NOT NULL,
  [nome] nvarchar(255) NOT NULL,
  [vinculacao] nvarchar(255),
  [carga_horaria] int
)
GO

CREATE TABLE [ParticipanteDetalhe] (
  [id] uuid PRIMARY KEY,
  [participante_id] uuid NOT NULL,
  [campo] nvarchar(255) NOT NULL,
  [valor] text
)
GO

CREATE TABLE [Tramitacao] (
  [id] uuid PRIMARY KEY,
  [projeto_id] uuid NOT NULL,
  [instituicao_id] uuid NOT NULL,
  [entidade] nvarchar(255) NOT NULL,
  [ordem] int NOT NULL,
  [status] nvarchar(255) NOT NULL,
  [observacao] text,
  [data_decisao] timestamp
)
GO

CREATE TABLE [Parecer] (
  [id] uuid PRIMARY KEY,
  [projeto_id] uuid NOT NULL,
  [instituicao_id] uuid NOT NULL,
  [tipo_parecer] nvarchar(255) NOT NULL,
  [data_emissao] timestamp
)
GO

CREATE TABLE [ParecerItem] (
  [id] uuid PRIMARY KEY,
  [parecer_id] uuid NOT NULL,
  [entidade] nvarchar(255) NOT NULL,
  [ordem] int NOT NULL,
  [status] nvarchar(255) NOT NULL,
  [comentario] text
)
GO

CREATE TABLE [ProjetoHistorico] (
  [id] uuid PRIMARY KEY,
  [projeto_id] uuid NOT NULL,
  [instituicao_id] uuid NOT NULL,
  [alterado_por] nvarchar(255) NOT NULL,
  [data_alteracao] timestamp NOT NULL,
  [alteracoes] json,
  [motivo] text
)
GO

ALTER TABLE [Projeto] ADD FOREIGN KEY ([instituicao_id]) REFERENCES [Instituicao] ([id])
GO

ALTER TABLE [Projeto] ADD FOREIGN KEY ([id]) REFERENCES [ProjetoPesquisa] ([projeto_id])
GO

ALTER TABLE [Projeto] ADD FOREIGN KEY ([id]) REFERENCES [ProjetoEnsino] ([projeto_id])
GO

ALTER TABLE [Projeto] ADD FOREIGN KEY ([id]) REFERENCES [ProjetoLiga] ([projeto_id])
GO

ALTER TABLE [FormularioCampo] ADD FOREIGN KEY ([formulario_id]) REFERENCES [Formulario] ([id])
GO

ALTER TABLE [ProjetoFormulario] ADD FOREIGN KEY ([projeto_id]) REFERENCES [Projeto] ([id])
GO

ALTER TABLE [ProjetoFormulario] ADD FOREIGN KEY ([formulario_id]) REFERENCES [Formulario] ([id])
GO

ALTER TABLE [ProjetoFormularioResposta] ADD FOREIGN KEY ([projeto_formulario_id]) REFERENCES [ProjetoFormulario] ([id])
GO

ALTER TABLE [ProjetoFormularioResposta] ADD FOREIGN KEY ([campo_id]) REFERENCES [FormularioCampo] ([id])
GO

ALTER TABLE [Participante] ADD FOREIGN KEY ([projeto_id]) REFERENCES [Projeto] ([id])
GO

ALTER TABLE [Participante] ADD FOREIGN KEY ([instituicao_id]) REFERENCES [Instituicao] ([id])
GO

ALTER TABLE [ParticipanteDetalhe] ADD FOREIGN KEY ([participante_id]) REFERENCES [Participante] ([id])
GO

ALTER TABLE [Tramitacao] ADD FOREIGN KEY ([projeto_id]) REFERENCES [Projeto] ([id])
GO

ALTER TABLE [Tramitacao] ADD FOREIGN KEY ([instituicao_id]) REFERENCES [Instituicao] ([id])
GO

ALTER TABLE [Parecer] ADD FOREIGN KEY ([projeto_id]) REFERENCES [Projeto] ([id])
GO

ALTER TABLE [ParecerItem] ADD FOREIGN KEY ([parecer_id]) REFERENCES [Parecer] ([id])
GO

ALTER TABLE [ProjetoHistorico] ADD FOREIGN KEY ([projeto_id]) REFERENCES [Projeto] ([id])
GO

ALTER TABLE [ProjetoHistorico] ADD FOREIGN KEY ([instituicao_id]) REFERENCES [Instituicao] ([id])
GO

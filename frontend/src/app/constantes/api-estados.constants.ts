
// 1. Enum para identificar o TIPO DE VISUALIZAÇÃO/ENTIDADE
export enum EntidadePendencia {
  COMITE_ETICA = 'ComiteEtica',
  COMITE_ETICA_HUMANA = 'ComiteEticaHumana',
  COMITE_ETICA_ANIMAL = 'ComiteEticaAnimal',
  COMISSAO_EXTENSAO = 'ComissaoExtensao',
  COMISSAO_PESQUISA = 'ComissaoPesquisa',
  CONSELHO_CENTRO = 'ConselhoCentro',
  CONSELHO_CAMPUS = 'ConselhoCampus',
  PRPPG = 'Prppg',
  PROEX = 'Proex',
  PROGRAD = 'Prograd',
}

// Tipo para o valor de cada entidade
interface EntidadeConfig {
  estado: string;
  titulo: string;
}

// Tipo genérico do mapa interno
type EntidadePendenciaMap = Partial<Record<EntidadePendencia, EntidadeConfig>>;

// Tipo final do mapa de endpoints
type ApiEndpointMap = Record<string, EntidadePendenciaMap>;

// Mapeamento dos tipos de pendência
// O nome da chave 'cadastro-grupo' representa o 'tipo' de tarefa
export const API_ENDPOINT_MAP : ApiEndpointMap = {
  // A chave é o TIPO DE PENDÊNCIA (Grupo/Projeto) + ENTIDADE
  'cadastro-grupo-pesquisa': {
    [EntidadePendencia.COMISSAO_PESQUISA]: {
      estado: 'Aprovacao_ComissaoPesquisa',
      titulo: 'Comissão de Pesquisa - Cadastro de Grupos de Pesquisa',
    },
    [EntidadePendencia.CONSELHO_CENTRO]: {
      estado: 'Aprovacao_ConselhoCentro',
      titulo: 'Conselho de Centro - Cadastro de Grupos de Pesquisa',
    },
    [EntidadePendencia.CONSELHO_CAMPUS]: {
      estado: 'Aprovacao_ConselhoCampus',
      titulo: 'Conselho de Campus - Cadastro de Grupos de Pesquisa',
    },
    [EntidadePendencia.PRPPG]: {
      estado: 'Aprovacao_PRPPG',
      titulo: 'Pró-Reitoria de Pós-Graduação - Cadastro de Grupos de Pesquisa',
    }
  },

  'alteracao-grupo-pesquisa': {
      [EntidadePendencia.COMISSAO_PESQUISA]: {
        estado: 'Aprovacao_ComissaoPesquisa',
        titulo: 'Comissão de Pesquisa - Cadastro de Grupos de Pesquisa',
      },
      [EntidadePendencia.CONSELHO_CENTRO]: {
        estado: 'Aprovacao_ConselhoCentro',
        titulo: 'Conselho de Centro - Cadastro de Grupos de Pesquisa',
      },
      [EntidadePendencia.CONSELHO_CAMPUS]: {
        estado: 'Aprovacao_ConselhoCampus',
        titulo: 'Conselho de Campus - Cadastro de Grupos de Pesquisa',
      },
      [EntidadePendencia.PRPPG]: {
        estado: 'Aprovacao_PRPPG',
        titulo: 'Pró-Reitoria de Pós-Graduação - Cadastro de Grupos de Pesquisa',
      }
    },
    
  'cadastro-projeto-pesquisa': {
    [EntidadePendencia.COMITE_ETICA]: {
      estado: 'Aprovacao_ComiteEticaHumana',
      titulo: 'Comite Ética Humana - Cadastro de Projetos de Pesquisa',
    },
    [EntidadePendencia.COMITE_ETICA_ANIMAL]: {
      estado: 'Aprovacao_ComiteEticaAnimal',
      titulo: 'Comite Ética Animal  - Cadastro de Projetos de Pesquisa',
    },
    [EntidadePendencia.COMISSAO_PESQUISA]: {
      estado: 'Aprovacao_ComissaoPesquisa',
      titulo: 'Comissão de Pesquisa - Cadastro de Projetos de Pesquisa',
    },
    [EntidadePendencia.CONSELHO_CENTRO]: {
      estado: 'Aprovacao_ConselhoCentro',
      titulo: 'Conselho de Centro - Cadastro de Projetos de Pesquisa',
    },
    [EntidadePendencia.CONSELHO_CAMPUS]: {
      estado: 'Aprovacao_ConselhoCampus',
      titulo: 'Conselho de Campus - Cadastro de Projetos de Pesquisa',
    },
    // Adicionar outros tipos de pendência (ex: 'alteracao-grupo', 'cadastro-projeto')
  },
};
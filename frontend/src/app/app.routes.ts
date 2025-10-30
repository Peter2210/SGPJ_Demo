import { Routes } from '@angular/router';
import { EntidadePendencia } from './constantes/api-estados.constants';
import { authGuard } from './guards/auth-guard';

export const routes: Routes = [
  {
    path: 'Login',
    pathMatch: 'full',
    loadComponent: () => import('./components/login/login').then(m => m.Login)
  },
  {
    path: '',
    canActivate: [authGuard],
    canActivateChild: [authGuard],
    loadComponent: () => import('./components/home/home').then(m => m.Home),
    children: [
      // Redireciona o caminho raiz (/) para o Login se nenhuma rota filha for encontrada.
      // Página Principal
      {
       path: 'Discente',
       loadComponent: () => import('./components/home/discente/discente').then(m => m.Discente)
      },
      {
       path: 'Docente',
       loadComponent: () => import('./components/home/docente/docente').then(m => m.Docente)
      },
      {
       path: 'ComiteEtica',
       loadComponent: () => import('./components/home/comite-etica/comite-etica').then(m => m.ComiteEtica)
      },
      {
       path: 'ComissaoExtensao',
       loadComponent: () => import('./components/home/comissao-extensao/comissao-extensao').then(m => m.ComissaoExtensao)
      },
      {
       path: 'ComissaoPesquisa',
       loadComponent: () => import('./components/home/comissao-pesquisa/comissao-pesquisa').then(m => m.ComissaoPesquisa)
      },
      {
       path: 'ConselhoCentro',
       loadComponent: () => import('./components/home/conselho-centro/conselho-centro').then(m => m.ConselhoCentro)
      },
      {
       path: 'ConselhoCampus',
       loadComponent: () => import('./components/home/conselho-campus/conselho-campus').then(m => m.ConselhoCampus)
      },
      {
       path: 'ConselhoUniversitario',
       loadComponent: () => import('./components/home/conselho-universitario/conselho-universitario').then(m => m.ConselhoUniversitario)
      },
      {
       path: 'Proex',
       loadComponent: () => import('./components/home/proex/proex').then(m => m.Proex)
      },
      {
       path: 'Prograd',
       loadComponent: () => import('./components/home/prograd/prograd').then(m => m.Prograd)
      },
      {
       path: 'Prppg',
       loadComponent: () => import('./components/home/prppg/prppg').then(m => m.Prppg)
      },
      {
       path: 'Prograd',
       loadComponent: () => import('./components/home/prograd/prograd').then(m => m.Prograd)
      },
      {
       path: 'Prppg',
       loadComponent: () => import('./components/home/prppg/prppg').then(m => m.Prppg)
      },
      {
       path: 'SecretariaFinanceira',
       loadComponent: () => import('./components/home/secretaria-financeira/secretaria-financeira').then(m => m.SecretariaFinanceira)
      },
      {
       path: 'Colegiado',
       loadComponent: () => import('./components/home/colegiado/colegiado').then(m => m.Colegiado)
      },
      {
       path: 'Coordenacao',
       loadComponent: () => import('./components/home/coordenacao/coordenacao').then(m => m.Coordenacao)
      },


      // Ferramentas 
      {
        path: 'EditorProjeto',
        loadComponent: () => import('./components/home/text-editor/text-editor').then(m => m.TextEditor)
      },
      {
        path: 'Docente/ProjetoPesquisa',
        loadComponent: () => import('./components/home/formularios/projeto-pesquisa-form/projeto-pesquisa-form').then(m => m.ProjetoPesquisaForm)
      },
      {
        path: 'Docente/GrupoDePesquisa',
        loadComponent: () => import('./components/home/formularios/grupo-pesquisa-form/grupo-pesquisa-form').then(m => m.GrupoPesquisaForm)
      },

      // Pendencias de aprovação
      //Uso de caminho mais dinamico
      {
        path: ':entidade/Pendencias',
        loadComponent: () => import('./components/home/listar-pendencias/listar-pendencias').then(m => m.ListarPendencias),
        children: [
          {
            path: 'Grupo',
            loadComponent: () => import('./components/home/listar-pendencias/listar-grupo-pesquisa/listar-grupo-pesquisa').then(m => m.ListarGrupoPesquisa)
          },
          {
            path: 'Projeto',
            loadComponent: () => import('./components/home/listar-pendencias/projeto-pesquisa/projeto-pesquisa').then(m => m.ProjetoPesquisa)
          },
          {
            path: '',
            redirectTo: 'grupo',
            pathMatch: 'full'
          }
        ]
      },
      {
        path: 'ComiteEtica/Pendencias',
        redirectTo: `${EntidadePendencia.COMITE_ETICA}/Pendencias`
      },
      {
        path: 'ComissaoExtensao/Pendencias',
        redirectTo: `${EntidadePendencia.COMISSAO_EXTENSAO}/Pendencias`
      },
      {
        path: 'ComissaoPesquisa/Pendencias',
        redirectTo: `${EntidadePendencia.COMISSAO_PESQUISA}/Pendencias`
      },
      {
        path: 'ConselhoCentro/Pendencias',
        redirectTo: `${EntidadePendencia.CONSELHO_CENTRO}/Pendencias`
      },
      {
        path: 'ConselhoCampus/Pendencias',
        redirectTo: `${EntidadePendencia.CONSELHO_CAMPUS}/Pendencias`
      },
      {
        path: 'Prppg/Pendencias',
        redirectTo: `${EntidadePendencia.PRPPG}/Pendencias`
      }
    ]
  },
  // Rota para qualquer URL não mapeada
  {
    path: '**',
    redirectTo: 'Login'
  }
];

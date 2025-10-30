import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  title = '';
  userType: string | null = null;

  menuItems: { label: string; link: string }[] = [];

  constructor(private router: Router) {
    this.userType = localStorage.getItem('userType');
    this.buildMenu();
  }

  navigateHome() {
    switch (this.userType) {
      case 'DISCENTE':
        this.router.navigate(['/Discente']);
        break;
      
      case 'DOCENTE':
        this.router.navigate(['/Docente']);
        break;
      
      case 'COMITE_ETICA':
        this.router.navigate(['/ComiteEtica']);
        break;

      case 'COMISSAO_EXTENSAO':
        this.router.navigate(['/ComissaoExtensao']);
        break;

      case 'COMISSAO_PESQUISA':
        this.router.navigate(['/ComissaoPesquisa']);
        break;

      case 'CONSELHO_CENTRO':
        this.router.navigate(['/ConselhoCentro']);
        break;

      case 'CONSELHO_CAMPUS':
        this.router.navigate(['/ConselhoCampus']);
        break;

      case 'CONSELHO_UNI':
        this.router.navigate(['/ConselhoUniversitario']);
        break;
      
      case 'PROEX':
        this.router.navigate(['/Proex']);
        break;

      case 'PROGRAD':
        this.router.navigate(['/Prograd']);
        break;
      
      case 'PRPPG':
        this.router.navigate(['/Prppg']);
        break;

      case 'SECRETARIA_FINANCEIRA':
        this.router.navigate(['/SecretariaFinanceira']);
        break;

      case 'COLEGIADO_CURSO':
        this.router.navigate(['/Colegiado']);
        break;

      case 'COORDENACAO':
        this.router.navigate(['/Coordenacao']);
        break;
      
      default:
        this.menuItems = [
          { label: 'Página Inicial', link: '/' }
        ];
        break;
    }
  }

  buildMenu() {
    switch (this.userType) {
      case 'DOCENTE':
        this.title = "DOCENTE"
        this.menuItems = [
          { label: 'Editor de Projeto', link: '/EditorProjeto' },
          { label: 'Grupo de Pesquisa', link: '/Docente/GrupoDePesquisa' },
          { label: 'Projeto de Pesquisa', link: '/Docente/ProjetoPesquisa'}
        ];
        break;
            
      case 'COMITE_ETICA':
        this.title = "COMITE ÉTICA"
        this.menuItems = [
          { label: 'Pendências Comite Ética', link: '/ComiteEtica/Pendencias' }
        ];
        break;
      
      case 'COMISSAO_EXTENSAO':
        this.title = "COMISSÂO DE EXTENSÃO"
        this.menuItems = [
          { label: 'Pendências Comissão de Extensão', link: '/ComissaoExtensao/Pendencias' }
        ];
        break;
            
      case 'COMISSAO_PESQUISA':
        this.title = "COMISSÂO DE PESQUISA"
        this.menuItems = [
          { label: 'Pendências Comissão de Pesquisa', link: '/ComissaoPesquisa/Pendencias' }
        ];
        break;
      
      case 'CONSELHO_CENTRO':
        this.title = "CONSELHO DE CENTRO"
        this.menuItems = [
          { label: 'Pendências Conselho de Centro', link: '/ConselhoCentro/Pendencias' }
        ];
        break;
            
      case 'CONSELHO_CAMPUS':
        this.title = "CONSELHO CAMPUS"
        this.menuItems = [
          { label: 'Pendências Conselho de Campus', link: '/ConselhoCampus/Pendencias' }
        ];
        break;
      
      case 'CONSELHO_UNI':
        this.title = "CONSELHO UNIVERSITÁRIO"
        this.menuItems = [
          { label: 'Pendências Conselho Universitário', link: '/ConselhoUniversitario/Pendencias' }
        ];
        break;
      
      case 'PROEX':
        this.title = "PROEX"
        this.menuItems = [
          { label: 'Projetos de Extensão', link: '/GrupoDePesquisa' },
          { label: 'Pendências Pró-Reitoria Extensão', link: '/Proex/Pendencias' }
        ];
        break;

      case 'PROGRAD':
        this.title = "PROGRAD"
        this.menuItems = [
          { label: 'Projetos de Extensão', link: '/GrupoDePesquisa' },
          { label: 'Pendências Pró-Reitoria Graduação', link: '/Prograd/Pendencias' }
        ];
        break;

      case 'PRPPG':
        this.title = "PRPPG"
        this.menuItems = [
          { label: 'Projetos de Extensão', link: '/GrupoDePesquisa' },
          { label: 'Pendências Pró-Reitoria Pós-Graduação', link: '/Prppg/Pendencias' }
        ];
        break;
            
      case 'SECRETARIA_FINANCEIRA':
        this.title = "SECRETARIA FINANCEIRA"
        this.menuItems = [
          { label: 'Pendências Secretaria Financeira', link: '/SecretariaFinanceira/Pendencias' }
        ];
        break;
            
      case 'COLEGIADO_CURSO':
        this.title = "COLEGIADO"
        this.menuItems = [
          { label: 'Pendências Colegiado', link: '/Colegiado/Pendencias' }
        ];
        break;
            
      case 'COORDENACAO':
        this.title = "COORDENAÇÃO"
        this.menuItems = [
          { label: 'Pendências Coordenação', link: '/Coordenacao/Pendencias' }
        ];
        break;
      

      default:
        this.menuItems = [
          { label: 'Página Inicial', link: '/' }
        ];
        break;
    }
    
  }
  logout() {
    localStorage.clear();
    this.router.navigate(['/Login']);
  }
}

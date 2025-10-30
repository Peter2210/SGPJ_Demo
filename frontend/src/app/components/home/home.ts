import { Component } from '@angular/core';
import { Header } from '../header/header';
import { Router, RouterOutlet } from '@angular/router';

interface MenuItem {
  label: string;
  path: string;
}

@Component({
  selector: 'app-home',
  imports: [Header, RouterOutlet],
  templateUrl: './home.html',
  styleUrl: './home.css'
})

export class Home {
  userType: string | null = null;
  menuItems: MenuItem[] = [];

  constructor(private router: Router) {}

  private menuMap: Record<string, MenuItem[]> = {
    'DISCENTE': [
      { label: 'Área Discente', path: 'Discente'}
    ],
    'DOCENTE': [
      { label: 'Área Docente', path: 'Docente'}
    ],
    'COMITE_ETICA': [
      { label: 'Área Ética', path: 'ComiteEtica' }
    ],
    'COMISSAO_EXTENSAO': [
      { label: 'Área Extensão', path: 'ComissaoExtensao' }
    ],
    'COMISSAO_PESQUISA': [
      { label: 'Área Pesquisa', path: 'ComissaoPesquisa' }
    ],
    'COMISSAO_UNI': [
      { label: 'Área Universitária', path: 'ComissaoUniversitaria' }
    ],
    'CONSELHO_CENTRO': [
      { label: 'Área do Conselho de Centro', path: 'ConselhoCentro' }
    ],
    'CONSELHO_CAMPUS': [
      { label: 'Área do Conselho de Campus', path: 'ConselhoCampus' }
    ],
    'PROEX': [
      { label: 'Área PROEX', path: 'Proex' }
    ],
    'PROGRAD': [
      { label: 'Área PROGRAD', path: 'Prograd' }
    ],
    'PRPPG': [
      { label: 'Área PRPPG', path: 'Prppg' }
    ],
    'SECRETARIA_FINANCEIRA': [
      { label: 'Área Secretaria Financeira', path: 'SecretariaFinanceira' }
    ],
    'COLEGIADO_CURSO': [
      { label: 'Área Colegiado Curso', path: 'Colegiado' }
    ],
    'COORDENACAO': [
      { label: 'Área Coordenação', path: 'Coordenacao' }
    ],
  };

  ngOnInit() {
    this.userType = localStorage.getItem('userType');

    if (!this.userType) {
      this.router.navigate(['/Login']);
      return;
    }

    this.menuItems = this.menuMap[this.userType] || [];

    if (this.menuItems.length > 0) {
      const firstPath = this.menuItems[0].path;
      this.router.navigate([`/${firstPath}`], { replaceUrl: true });
    }
  }
}

import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})

export class Login {
  username = '';
  password = '';
  userType = '';
  error = '';

  userTypes = [
    { label: 'Discente', value: 'DISCENTE' },
    { label: 'Docente', value: 'DOCENTE' },
    { label: 'Comitê de Ética', value: 'COMITE_ETICA' },
    { label: 'Comissão de Extensão', value: 'COMISSAO_EXTENSAO' },
    { label: 'Comissão de Pesquisa', value: 'COMISSAO_PESQUISA' },
    { label: 'Conselho de Centro', value: 'CONSELHO_CENTRO' },
    { label: 'Conselho de Campus', value: 'CONSELHO_CAMPUS' },
    { label: 'Conselho Universitário', value: 'CONSELHO_UNI' },
    { label: 'Pró-Reitoria De Extensão', value: 'PROEX' },
    { label: 'Pró-Reitoria De Graduação', value: 'PROGRAD' },
    { label: 'Pró-Reitoria De Pós-Graduação', value: 'PRPPG' },
    { label: 'Secretaria Financeira do Campus', value: 'SECRETARIA_FINANCEIRA' },
    { label: 'Colegiado do Curso', value: 'COLEGIADO_CURSO' },
    { label: 'Coordenação', value: 'COORDENACAO' }
  ];

  constructor(private router: Router) {
    localStorage.clear();
  }

  login() {
    if (!this.userType) {
      this.error = 'Por favor, selecione o tipo de usuário.';
      return;
    }

    // Validação real via API
    localStorage.setItem('userType', this.userType);
    localStorage.setItem('username', this.username);
    this.router.navigate(['/']);
  }
}
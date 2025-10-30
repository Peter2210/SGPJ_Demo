import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ProjetoPesquisa {
  id: string;
  tituloProjeto: string;
  nomeGrupo: string;
  descricaoProjeto: string;
}

@Injectable({
  providedIn: 'root'
})

export class PendenciasProjetoPesquisa {
    private apiUrl = 'http://localhost:8081/api/prppg';

  constructor(private http: HttpClient) {}

  getProjetosPendentes(estado: string): Observable<ProjetoPesquisa[]> {
    const url = `${this.apiUrl}/projetosPesq/aprovacoes?estado=${estado}`;
    return this.http.get<ProjetoPesquisa[]>(url);
  }

  decidirProjeto(id: string, aprovado: boolean): Observable<any> {
    const url = `${this.apiUrl}/projetosPesq/decisoes`;
    return this.http.post(url, { id, aprovado });
  }
}

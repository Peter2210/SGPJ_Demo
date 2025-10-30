import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface GrupoPesquisa {
  id: string;
  nomeGrupo: string;
  nomeLider: string;
  dataCriacao: string;
}

@Injectable({
  providedIn: 'root'
})

export class GrupoPesquisaService {
  private apiUrl = 'http://localhost:8081/api/prppg';

  constructor(private http: HttpClient) {}

  getGruposPendentes(estado: string): Observable<GrupoPesquisa[]> {
    const url = `${this.apiUrl}/gruposPesq/aprovacoes?estado=${estado}`;
    return this.http.get<GrupoPesquisa[]>(url);
  }

  decidirGrupo(id: string, aprovado: boolean): Observable<any> {
    const url = `${this.apiUrl}/gruposPesq/decisoes`;
    return this.http.post(url, { id, aprovado });
  }
}

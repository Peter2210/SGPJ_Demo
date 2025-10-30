import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router'; // Adicionado Router
import { GrupoPesquisa, GrupoPesquisaService } from '../../../../services/PendenciasGrupoPesquisa/pendenciasGrupoService';
import { API_ENDPOINT_MAP, EntidadePendencia } from '../../../../constantes/api-estados.constants';
import { switchMap } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-grupo-pesquisa',
  standalone: true,
  imports: [CommonModule, DatePipe],
  templateUrl: './listar-grupo-pesquisa.html',
  styleUrl: './listar-grupo-pesquisa.css'
})
export class ListarGrupoPesquisa implements OnInit {
  gruposPendentes: GrupoPesquisa[] = [];
  loading = true;
  private estado: string = ''; // Caminho da API real
  public titulo: string = 'Pendências de Aprovação'; 
  
  private readonly tipoPendenciaKey = 'cadastro-grupo-pesquisa'; 

  constructor(
    private GrupoPesquisaService: GrupoPesquisaService, 
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const entidadeKey = this.route.parent?.snapshot.paramMap.get('entidade') as EntidadePendencia;

    if (!entidadeKey || !API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey]) {
      console.error('Entidade de pendência inválida na URL:', entidadeKey);
      this.router.navigate(['/']); 
      return;
    }

    const config = API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey]!;
    this.estado = config.estado;
    this.titulo = config.titulo;

    this.GrupoPesquisaService.getGruposPendentes(this.estado).subscribe({
      next: (data: GrupoPesquisa[]) => {
        this.gruposPendentes = data;
        this.loading = false;
      },
      error: err => {
        console.error('Erro ao buscar pendências em', this.estado, err);
        this.loading = false;
      }
    });
  }

  
  verDetalhes(grupo: GrupoPesquisa): void {
    console.log('Detalhes do grupo:', grupo);
    // Aqui pode abrir um modal ou navegar para outra rota
  }

  decidirGrupo(grupo: GrupoPesquisa, decisao: boolean): void {
    if (!this.estado) return;

    if (confirm(`Deseja aprovar o grupo "${grupo.nomeGrupo}"?`)) {
      this.GrupoPesquisaService.decidirGrupo(grupo.id, decisao).subscribe({
        next: () => {
          alert('Grupo aprovado com sucesso!');
          this.gruposPendentes = this.gruposPendentes.filter(g => g.id !== grupo.id);
        },
        error: (err: unknown) => {
          console.error('Erro ao aprovar grupo', err);
          alert('Erro ao aprovar o grupo.');
        }
      });
    }
  }
}


import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { GrupoPesquisa, GrupoPesquisaService } from '../../../../services/PendenciasGrupoPesquisa/pendenciasGrupoService';
import { API_ENDPOINT_MAP, EntidadePendencia } from '../../../../constantes/api-estados.constants';

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
  private estado: string = '';
  public titulo: string = 'Pendências de Aprovação'; 
  
  tipoPendenciaKey : string = ''; 

  constructor(
    private GrupoPesquisaService: GrupoPesquisaService, 
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {}
  
  carregarGrupos(): void {
    const entidadeKey = this.route.parent?.snapshot.paramMap.get('entidade') as EntidadePendencia;

    if (!entidadeKey || !API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey]) {
      console.error('Entidade de pendência inválida na URL:', entidadeKey);
      this.router.navigate(['/']); 
      return;
    }

    const config = API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey]!;
    this.estado = config.estado;
    this.titulo = config.titulo;

    this.loading = true;
    this.GrupoPesquisaService.getGruposPendentes(this.estado).subscribe({
      next: data => {
        this.gruposPendentes = data;
        this.loading = false;
      },
      error: err => {
        console.error('Erro ao buscar pendências', err);
        this.loading = false;
      }
    });
  }
  
  verDetalhes(grupo: GrupoPesquisa): void {
    console.log('Detalhes do grupo:', grupo);
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

  viewChange(modo : String){
    switch(modo){
      case "Cadastrar":
        this.tipoPendenciaKey = 'cadastro-grupo-pesquisa';
      break;
      case "Alterar":
        this.tipoPendenciaKey = 'alterar-grupos-pesquisa';
      break;
    }
    //Recarrega lista
    this.carregarGrupos()
  }
  
}


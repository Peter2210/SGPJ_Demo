import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PendenciasProjetoPesquisa, ProjetoPesquisa } from '../../../../services/PendeciasProjetoPesquisa/pendencias-projeto-pesquisa';
import { ActivatedRoute, Router } from '@angular/router';
import { API_ENDPOINT_MAP, EntidadePendencia } from '../../../../constantes/api-estados.constants';

@Component({
  selector: 'app-projeto-pesquisa',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-projeto-pesquisa.html',
  styleUrls: ['./listar-projeto-pesquisa.css']
})
export class ListarProjetoPesquisa implements OnInit{
  projetosPendentes: ProjetoPesquisa[] = []
  public loading = true
  private estado: string = '';
  public titulo: string = 'Pendências de Aprovação'; 
  
  private readonly tipoPendenciaKey = 'cadastro-projeto-pesquisa'; 

  constructor(
    private ProjetoPesquisaService: PendenciasProjetoPesquisa, 
    private route: ActivatedRoute,
    private router: Router){}
  
  ngOnInit(): void {
    const entidadeKey = this.route.parent?.snapshot.paramMap.get('entidade') as EntidadePendencia;
    
    if ( !entidadeKey ||  !API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey] ){
      console.error('Entidade de pendência inválida na URL:', entidadeKey);
      this.router.navigate(['/']); 
      return;
    }
    const config = API_ENDPOINT_MAP[this.tipoPendenciaKey][entidadeKey]!;
    this.estado = config.estado;
    this.titulo = config.titulo;

    this.ProjetoPesquisaService.getProjetosPendentes(this.estado).subscribe({
      next: (data: ProjetoPesquisa[]) => {
        this.projetosPendentes = data;
        this.loading = false;
      },
      error: err => {
        console.error('Erro ao buscar pendências em', this.estado, err);
        this.loading = false;
      }
    })
  }

  decidirProjeto(projeto: ProjetoPesquisa, decisao: boolean): void {
    if (!this.estado) return;
  
    if (confirm(`Deseja aprovar o grupo "${projeto.tituloProjeto}"?`)) {
      this.ProjetoPesquisaService.decidirProjeto(projeto.id, decisao).subscribe({
        next: () => {
          alert('Grupo aprovado com sucesso!');
          this.projetosPendentes = this.projetosPendentes.filter(g => g.id !== projeto.id);
        },
        error: (err: unknown) => {
          console.error('Erro ao aprovar grupo', err);
          alert('Erro ao aprovar o grupo.');
        }
      });
    }
  }
}

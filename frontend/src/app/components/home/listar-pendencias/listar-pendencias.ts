import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-listar-pendencias',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './listar-pendencias.html',
  styleUrls: ['./listar-pendencias.css']
})

export class ListarPendencias {
}

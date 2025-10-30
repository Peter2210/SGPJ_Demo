// src/app/projeto-pesquisa-form/projeto-pesquisa-form.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { QuillModule } from 'ngx-quill';

@Component({
  selector: 'projeto-pesquisa-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, QuillModule],
  templateUrl: './projeto-pesquisa-form.html',
  styleUrls: ['./projeto-pesquisa-form.css']
})
export class ProjetoPesquisaForm {
  formGroup: FormGroup;

  quillModules = {
    toolbar: [
      [{ header: [1, 2, 3, false] }],
      ['bold', 'italic', 'underline'],
      ['blockquote', 'code-block'],
      [{ list: 'ordered' }, { list: 'bullet' }],
      [{ align: [] }],
      ['link', 'image'],
      ['clean']
    ]
  };

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.formGroup = this.fb.group({
      tituloProjeto: ['', Validators.required],
      vinculadoGrupoPesquisa: [false],
      qualGrupoPesquisa: [''],
      vigenciaInicio: [''],
      vigenciaFim: [''],
      participantes: [''],
      resumo: ['', Validators.maxLength(1000)],

      // Os ODS podem ser um grupo com checkboxes, por simplicidade deixo só texto aqui:
      odsSelecionados: [''],

      palavrasChave: [''],

      grandeArea: [''],
      codigoGrandeArea: [''],
      area: [''],
      codigoArea: [''],
      subarea: [''],
      codigoSubarea: [''],

      descricaoProjeto: ['', Validators.required],

      referencias: [''],

      envolveEticaHumana: [false],
      envolveEticaAnimal: [false],
      envolveSISGEN: [false]
    });
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      alert('Por favor, preencha os campos obrigatórios.');
      return;
    }

    const formData = this.formGroup.value;
    console.log("Form enviado:", this.formGroup.value);

    // POST para API
    this.http.post('http://localhost:8081/api/process/ProjetoPesquisa', {
      processKey: 'cadastro-projeto-pesquisa',
      variables: {
        formData: formData,
      }
    }, { responseType: 'text' }).subscribe({
      next: res => console.log('Process started:', res),
      error: err => console.error('Error:', err)
    });
  }
}

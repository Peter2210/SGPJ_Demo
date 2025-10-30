import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'formulario',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './grupo-pesquisa-form.html',
  styleUrl: './grupo-pesquisa-form.css'
})

export class GrupoPesquisaForm {
  formGroup: FormGroup;

  odsList = [
    { id: 'ods1', label: '1. ERRADICAÇÃO DA POBREZA' },
    { id: 'ods2', label: '2. FOME ZERO E AGRICULTURA SUSTENTÁVEL' },
    { id: 'ods3', label: '3. SAÚDE E BEM-ESTAR' },
    { id: 'ods4', label: '4. EDUCAÇÃO DE QUALIDADE' },
    { id: 'ods5', label: '5. IGUALDADE DE GÊNERO' },
    { id: 'ods6', label: '6. ÁGUA LIMPA E SANEAMENTO' },
    { id: 'ods7', label: '7. ENERGIA ACESSÍVEL E LIMPA' },
    { id: 'ods8', label: '8. TRABALHO DECENTE E CRESCIMENTO ECONÔMICO' },
    { id: 'ods9', label: '9. INDÚSTRIA, INOVAÇÃO E INFRAESTRUTURA' },
    { id: 'ods10', label: '10. REDUÇÃO DAS DESIGUALDADES' },
    { id: 'ods11', label: '11. CIDADES E COMUNIDADES SUSTENTÁVEIS' },
    { id: 'ods12', label: '12. CONSUMO E PRODUÇÃO RESPONSÁVEIS' },
    { id: 'ods13', label: '13. AÇÃO CONTRA A MUDANÇA GLOBAL DO CLIMA' },
    { id: 'ods14', label: '14. VIDA NA ÁGUA' },
    { id: 'ods15', label: '15. VIDA TERRESTRE' },
    { id: 'ods16', label: '16. PAZ, JUSTIÇA E INSTITUIÇÕES EFICAZES' },
    { id: 'ods17', label: '17. PARCERIAS E MEIOS DE IMPLEMENTAÇÃO' }
  ];

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.formGroup = this.fb.group({
      nomeGrupo: ['', Validators.required],

      nomeLider: [''],
      centroLider: [''],
      emailLider: [''],

      nomeViceLider: [''],
      centroViceLider: [''],
      emailViceLider: [''],

      pesquisadores: this.fb.array([]),

      grandeArea: [''],
      codigoGrandeArea: [''],
      area: [''],
      codigoArea: [''],
      subarea: [''],
      codigoSubarea: [''],

      objetivos: [''],
      linhasPesquisa: [''],

      ods: this.fb.group(
        this.odsList.reduce((acc, ods) => {
          acc[ods.id] = [false];
          return acc;
        }, {} as { [key: string]: any })
      )
    });

    // Add one empty pesquisador by default
    this.adicionarPesquisador();
  }

  get pesquisadores() {
    return this.formGroup.get('pesquisadores') as FormArray;
  }

  adicionarPesquisador() {
    const pesquisadorGroup = this.fb.group({
      nome: [''],
      centroInstituicao: [''],
      tipo: ['Efetivo']
    });
    this.pesquisadores.push(pesquisadorGroup);
  }

  removerPesquisador(index: number) {
    this.pesquisadores.removeAt(index);
  }

  onSubmit() {
    if (this.formGroup.invalid) {
      alert("Por favor, preencha todos os campos obrigatórios.");
      return;
    }

    const formData = this.formGroup.value;

    console.log('Submitting form data:', formData);
    console.log("Form enviado:", this.formGroup.value);
    console.log("Pesquisadores:", this.formGroup.value.pesquisadores);
    
    // POST para API
    this.http.post('http://localhost:8081/api/process/GrupoPesquisa', {
      processKey: 'cadastro-grupos-pesquisa',
      variables: {
        formData: formData
      }
    }, { responseType: 'text' }).subscribe({
      next: res => console.log('Process started:', res),
      error: err => console.error('Error:', err)
    });
  }
}
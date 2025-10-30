import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoPesquisaForm } from './grupo-pesquisa-form';

describe('Formulario', () => {
  let component: GrupoPesquisaForm;
  let fixture: ComponentFixture<GrupoPesquisaForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GrupoPesquisaForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GrupoPesquisaForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

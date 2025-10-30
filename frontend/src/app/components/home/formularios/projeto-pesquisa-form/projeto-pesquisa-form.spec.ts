import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetoPesquisaForm } from './projeto-pesquisa-form';

describe('ProjetoPesquisaForm', () => {
  let component: ProjetoPesquisaForm;
  let fixture: ComponentFixture<ProjetoPesquisaForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProjetoPesquisaForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjetoPesquisaForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

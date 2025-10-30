import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarGrupoPesquisa } from './listar-grupo-pesquisa';

describe('GrupoPesquisa', () => {
  let component: ListarGrupoPesquisa;
  let fixture: ComponentFixture<ListarGrupoPesquisa>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarGrupoPesquisa]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarGrupoPesquisa);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

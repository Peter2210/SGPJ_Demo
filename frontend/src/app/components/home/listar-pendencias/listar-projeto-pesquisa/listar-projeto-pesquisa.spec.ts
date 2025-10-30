import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarProjetoPesquisa } from './listar-projeto-pesquisa';

describe('ListarProjetoPesquisa', () => {
  let component: ListarProjetoPesquisa;
  let fixture: ComponentFixture<ListarProjetoPesquisa>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarProjetoPesquisa]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarProjetoPesquisa);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { GrupoPesquisaService } from './pendenciasGrupoService';

describe('GrupoPesquisa', () => {
  let service: GrupoPesquisaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GrupoPesquisaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

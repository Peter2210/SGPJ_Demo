import { TestBed } from '@angular/core/testing';

import { PendenciasProjetoPesquisa } from './pendencias-projeto-pesquisa';

describe('PendenciasProjetoPesquisa', () => {
  let service: PendenciasProjetoPesquisa;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PendenciasProjetoPesquisa);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

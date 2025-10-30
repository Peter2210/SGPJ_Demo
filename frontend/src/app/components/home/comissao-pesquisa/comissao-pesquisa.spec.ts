import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComissaoPesquisa } from './comissao-pesquisa';

describe('ComissaoPesquisa', () => {
  let component: ComissaoPesquisa;
  let fixture: ComponentFixture<ComissaoPesquisa>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComissaoPesquisa]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComissaoPesquisa);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

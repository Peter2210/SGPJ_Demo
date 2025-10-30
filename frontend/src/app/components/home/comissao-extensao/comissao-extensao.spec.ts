import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComissaoExtensao } from './comissao-extensao';

describe('ComissaoExtensao', () => {
  let component: ComissaoExtensao;
  let fixture: ComponentFixture<ComissaoExtensao>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComissaoExtensao]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComissaoExtensao);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

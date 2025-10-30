import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretariaFinanceira } from './secretaria-financeira';

describe('SecretariaFinanceira', () => {
  let component: SecretariaFinanceira;
  let fixture: ComponentFixture<SecretariaFinanceira>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SecretariaFinanceira]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SecretariaFinanceira);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Colegiado } from './colegiado';

describe('Colegiado', () => {
  let component: Colegiado;
  let fixture: ComponentFixture<Colegiado>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Colegiado]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Colegiado);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

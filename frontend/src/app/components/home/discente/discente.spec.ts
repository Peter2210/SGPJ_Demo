import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Discente } from './discente';

describe('Discente', () => {
  let component: Discente;
  let fixture: ComponentFixture<Discente>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Discente]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Discente);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

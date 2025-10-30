import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prppg } from './prppg';

describe('Prppg', () => {
  let component: Prppg;
  let fixture: ComponentFixture<Prppg>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Prppg]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Prppg);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

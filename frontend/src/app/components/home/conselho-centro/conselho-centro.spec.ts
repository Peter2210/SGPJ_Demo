import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConselhoCentro } from './conselho-centro';

describe('ConselhoCentro', () => {
  let component: ConselhoCentro;
  let fixture: ComponentFixture<ConselhoCentro>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConselhoCentro]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConselhoCentro);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

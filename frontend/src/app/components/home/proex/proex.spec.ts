import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Proex } from './proex';

describe('Proex', () => {
  let component: Proex;
  let fixture: ComponentFixture<Proex>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Proex]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Proex);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

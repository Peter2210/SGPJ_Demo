import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prograd } from './prograd';

describe('Prograd', () => {
  let component: Prograd;
  let fixture: ComponentFixture<Prograd>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Prograd]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Prograd);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

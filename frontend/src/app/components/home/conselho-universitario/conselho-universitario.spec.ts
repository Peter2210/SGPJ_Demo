import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConselhoUniversitario } from './conselho-universitario';

describe('ConselhoUniversitario', () => {
  let component: ConselhoUniversitario;
  let fixture: ComponentFixture<ConselhoUniversitario>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConselhoUniversitario]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConselhoUniversitario);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

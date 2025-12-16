import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComiteEticaHumana } from './comite-etica-humana';

describe('ComiteEticaHumana', () => {
  let component: ComiteEticaHumana;
  let fixture: ComponentFixture<ComiteEticaHumana>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComiteEticaHumana]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComiteEticaHumana);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

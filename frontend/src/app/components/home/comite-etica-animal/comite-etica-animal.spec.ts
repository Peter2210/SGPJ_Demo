import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComiteEticaAnimal } from './comite-etica-animal';

describe('ComiteEticaAnimal', () => {
  let component: ComiteEticaAnimal;
  let fixture: ComponentFixture<ComiteEticaAnimal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComiteEticaAnimal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComiteEticaAnimal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

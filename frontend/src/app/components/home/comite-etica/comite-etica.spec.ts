import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComiteEtica } from './comite-etica';

describe('ComiteEtica', () => {
  let component: ComiteEtica;
  let fixture: ComponentFixture<ComiteEtica>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComiteEtica]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComiteEtica);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

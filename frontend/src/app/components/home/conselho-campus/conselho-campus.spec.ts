import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConselhoCampus } from './conselho-campus';

describe('ConselhoCampus', () => {
  let component: ConselhoCampus;
  let fixture: ComponentFixture<ConselhoCampus>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConselhoCampus]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConselhoCampus);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

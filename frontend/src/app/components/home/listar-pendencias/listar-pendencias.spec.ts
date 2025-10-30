import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPendencias } from './listar-pendencias';

describe('ListarPendencias', () => {
  let component: ListarPendencias;
  let fixture: ComponentFixture<ListarPendencias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarPendencias]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPendencias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

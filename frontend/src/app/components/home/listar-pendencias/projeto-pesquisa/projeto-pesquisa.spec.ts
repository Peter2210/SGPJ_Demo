import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetoPesquisa } from './projeto-pesquisa';

describe('ProjetoPesquisa', () => {
  let component: ProjetoPesquisa;
  let fixture: ComponentFixture<ProjetoPesquisa>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProjetoPesquisa]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjetoPesquisa);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

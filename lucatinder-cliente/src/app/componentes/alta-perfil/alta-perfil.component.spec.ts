import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AltaPerfilComponent } from './alta-perfil.component';

describe('AltaPerfilComponent', () => {
  let component: AltaPerfilComponent;
  let fixture: ComponentFixture<AltaPerfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AltaPerfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AltaPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

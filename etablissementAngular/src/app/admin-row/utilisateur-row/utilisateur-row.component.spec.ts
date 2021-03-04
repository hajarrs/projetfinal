import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurRowComponent } from './utilisateur-row.component';

describe('UtilisateurRowComponent', () => {
  let component: UtilisateurRowComponent;
  let fixture: ComponentFixture<UtilisateurRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilisateurRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

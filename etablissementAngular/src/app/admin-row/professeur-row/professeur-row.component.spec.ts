import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesseurRowComponent } from './professeur-row.component';

describe('ProfesseurRowComponent', () => {
  let component: ProfesseurRowComponent;
  let fixture: ComponentFixture<ProfesseurRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfesseurRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfesseurRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

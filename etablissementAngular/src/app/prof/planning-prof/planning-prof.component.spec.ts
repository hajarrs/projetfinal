import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanningProfComponent } from './planning-prof.component';

describe('PlanningProfComponent', () => {
  let component: PlanningProfComponent;
  let fixture: ComponentFixture<PlanningProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanningProfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanningProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

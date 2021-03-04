import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursRowComponent } from './cours-row.component';

describe('CoursRowComponent', () => {
  let component: CoursRowComponent;
  let fixture: ComponentFixture<CoursRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

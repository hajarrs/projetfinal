import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleClasseRowComponent } from './salle-classe-row.component';

describe('SalleClasseRowComponent', () => {
  let component: SalleClasseRowComponent;
  let fixture: ComponentFixture<SalleClasseRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalleClasseRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleClasseRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

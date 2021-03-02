import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatiereRowComponent } from './matiere-row.component';

describe('MatiereRowComponent', () => {
  let component: MatiereRowComponent;
  let fixture: ComponentFixture<MatiereRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatiereRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatiereRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

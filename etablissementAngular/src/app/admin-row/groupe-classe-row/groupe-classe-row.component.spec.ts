import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupeClasseRowComponent } from './groupe-classe-row.component';

describe('GroupeClasseRowComponent', () => {
  let component: GroupeClasseRowComponent;
  let fixture: ComponentFixture<GroupeClasseRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroupeClasseRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupeClasseRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

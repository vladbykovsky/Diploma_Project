import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupBySubjectComponent } from './group-by-subject.component';

describe('GroupBySubjectComponent', () => {
  let component: GroupBySubjectComponent;
  let fixture: ComponentFixture<GroupBySubjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupBySubjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupBySubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

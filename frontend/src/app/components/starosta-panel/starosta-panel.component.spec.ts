import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StarostaPanelComponent } from './starosta-panel.component';

describe('StarostaPanelComponent', () => {
  let component: StarostaPanelComponent;
  let fixture: ComponentFixture<StarostaPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StarostaPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StarostaPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

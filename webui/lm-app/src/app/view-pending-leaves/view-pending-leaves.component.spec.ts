import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPendingLeavesComponent } from './view-pending-leaves.component';

describe('ViewPendingLeavesComponent', () => {
  let component: ViewPendingLeavesComponent;
  let fixture: ComponentFixture<ViewPendingLeavesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPendingLeavesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPendingLeavesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

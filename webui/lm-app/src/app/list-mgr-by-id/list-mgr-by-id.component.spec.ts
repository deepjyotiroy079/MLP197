import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMgrByIdComponent } from './list-mgr-by-id.component';

describe('ListMgrByIdComponent', () => {
  let component: ListMgrByIdComponent;
  let fixture: ComponentFixture<ListMgrByIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMgrByIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMgrByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

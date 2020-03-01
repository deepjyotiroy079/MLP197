import { TestBed } from '@angular/core/testing';

import { LeaveDetailsService } from './leave-details.service';

describe('LeaveDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeaveDetailsService = TestBed.get(LeaveDetailsService);
    expect(service).toBeTruthy();
  });
});

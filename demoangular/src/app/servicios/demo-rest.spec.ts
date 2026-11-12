import { TestBed } from '@angular/core/testing';

import { DemoRest } from './demo-rest';

describe('DemoRest', () => {
  let service: DemoRest;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemoRest);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

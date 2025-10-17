import { TestBed } from '@angular/core/testing';

import { Webclient } from './webclient';

describe('Webclient', () => {
  let service: Webclient;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Webclient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

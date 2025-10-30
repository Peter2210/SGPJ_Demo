import { TestBed } from '@angular/core/testing';

import { WebSecurity } from './web-security';

describe('WebSecurity', () => {
  let service: WebSecurity;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WebSecurity);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

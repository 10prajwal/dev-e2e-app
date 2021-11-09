import { TestBed } from '@angular/core/testing';

import { AutoInsuranceClaimService } from './auto-insurance-claim.service';

describe('AutoInsuranceClaimService', () => {
  let service: AutoInsuranceClaimService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutoInsuranceClaimService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

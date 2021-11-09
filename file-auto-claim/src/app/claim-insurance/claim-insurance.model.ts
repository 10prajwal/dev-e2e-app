export interface AutoClaim {
  claimId: number;
  accidentTime: string;
  policyHolder: PolicyHolder;
}

export interface PolicyHolder {
  fullName: string;
  emailAddress: string;
}

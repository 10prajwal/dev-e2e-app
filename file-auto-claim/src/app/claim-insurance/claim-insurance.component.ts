import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { AutoInsuranceClaimService } from "../service/auto-insurance-claim.service";
import { AutoClaim } from "./claim-insurance.model";

@Component({
  selector: "app-claim-insurance",
  templateUrl: "./claim-insurance.component.html",
  styleUrls: ["./claim-insurance.component.scss"],
})
export class ClaimInsuranceComponent implements OnInit {
  constructor(private claimService: AutoInsuranceClaimService) {}

  policyDetailsForm: FormGroup = new FormGroup({});

  isClaimSubmitted = false;

  claimDetails: AutoClaim | undefined;

  isError = false;

  ngOnInit(): void {
    this._initializeForms();
  }

  private _initializeForms() {
    this.policyDetailsForm = new FormGroup({
      fullName: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      accidentDateTime: new FormControl("", Validators.required),
    });
  }

  public claimInsurance() {
    this.isClaimSubmitted = false;

    if (this.policyDetailsForm.invalid) {
      this.isError = true;
    } else {
      const claimDetails: AutoClaim = {
        accidentTime: this.getAccidentTime?.value,
        policyHolder: {
          fullName: this.getFullName?.value,
          emailAddress: this.getEmail?.value,
        },
      } as AutoClaim;
      this.isError = false;
      this.claimService.createNewClaim(claimDetails).subscribe(
        (response) => {
          this.isClaimSubmitted = true;
          this.claimDetails = response;
          this.isError = false;
        },
        (err) => {
          console.log("error while submitting details");
          console.log(err);
          this.isClaimSubmitted = false;
        }
      );
    }
  }

  private get getFullName() {
    return this.policyDetailsForm.get("fullName");
  }

  private get getEmail() {
    return this.policyDetailsForm.get("email");
  }

  private get getAccidentTime() {
    return this.policyDetailsForm.get("accidentDateTime");
  }
}

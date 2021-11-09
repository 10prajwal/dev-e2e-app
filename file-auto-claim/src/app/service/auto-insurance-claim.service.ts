import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { isEmpty } from "lodash";
import { AutoClaim } from "../claim-insurance/claim-insurance.model";
import { DOMAIN_NAME } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class AutoInsuranceClaimService {
  public claimUrl = DOMAIN_NAME + "/api/claim-management/auto-claims";

  constructor(private httpClient: HttpClient) {}

  public createNewClaim(claimDetails: AutoClaim): Observable<AutoClaim> {
    return this.httpClient.post(this.claimUrl, claimDetails).pipe(
      map((response) => {
        return response as AutoClaim;
      })
    );
  }
}

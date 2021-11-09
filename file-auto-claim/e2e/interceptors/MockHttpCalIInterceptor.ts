import { Injectable } from "@angular/core";
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
} from "@angular/common/http";
import { Observable, of } from "rxjs";
import { AutoClaim } from "../../src/app/claim-insurance/claim-insurance.model";

@Injectable()
export class MockHttpCalIInterceptor implements HttpInterceptor {
  constructor() {}
  public createClaimUrl: string = "/api/claim-management/auto-claims";
  public generateClaimId: number = 10;
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    console.log("Intercepted request" + request.url);
    if (
      request.url.includes(this.createClaimUrl) &&
      request.method === "POST"
    ) {
      this.generateClaimId += 1;
      const createdClaim: AutoClaim = {
        claimId: this.generateClaimId,
        accidentTime: "2021-10-06T16:29",
        policyHolder: {
          fullName: "Prajwal",
          emailAddress: "shetty10@gmail.com",
        },
      };
      return of(new HttpResponse({ status: 200, body: createdClaim }));
    }
    return next.handle(request);
  }
}

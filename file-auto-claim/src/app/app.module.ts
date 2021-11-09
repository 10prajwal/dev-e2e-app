import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MockHttpCalIInterceptor } from 'e2e/interceptors/MockHttpCalIInterceptor';
import { environment } from 'src/environments/environment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { HttpRequestInterceptor } from './HttpRequestInterceptor';

export const isMock = environment.mock;

@NgModule({
  declarations: [AppComponent, ClaimInsuranceComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: isMock ? MockHttpCalIInterceptor : HttpRequestInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

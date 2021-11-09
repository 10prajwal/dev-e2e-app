# Assessment Requirement - Online Claim for ABC Company

## Introduction

ABC Insurance Company is planning to build a solution to help its customers file Auto Insurance claim online.
This helps the users to quickly submit the claim in the occurrence of an unfortunate event like accident, loss, or theft of the vehicle.

You are expected to help ABC Company to achieve its goal by building the API services.

## Below are the services which you are expected to build.

1. Service to create a new Claim

## Technology Stack

1. Spring Boot
1. Java version - 11+
1. Git client
1. Gradle for build
1. Any IDE that you are comfortable with (Spring Tool Suite, Eclipse)

The project provided has the required dependencies for Spring Boot, Java 11. You will not be required to add additional dependencies to the project in most cases.

## Services

### Points to remember

1. The context root of the project should be /api/claim-management
1. Disable CSRF Protection for the application.
1. Some of the code is already implemented. Like the Domain Model, Entity classes (partially), Service class (partial).
   Understand the code and write the remaining code. Or you are free to rewrite provided you do not change the following 1. Request & Response Structure 1. Database Table Structure
1. Do not change the Request & Response specification of the APIs
1. Do not change Database Table Structure

### 1. Create new Claim

The service is expected to create a new claim for the details provided. It returns the claim reference ID (claimId in the below response) which can later be used to retrieve the claim.

Below is a sample specification of this API

#### Request Details

POST /api/claim-management/auto-claims

##### Request Body

\*\* Use the appropriate content type

```json
{
  "policyNumber": "123123",
  "accidentTime": "2004-10-19T10:23:54",
  "policyHolder": {
    "firstName": "John",
    "lastName": "Cena",
    "emailAddress": "john.cena@mail.com"
  }
}
```

#### Response Details

Possible Status

- 201 CREATED

#### Response Body

\*\*Claim ID is used to retrieve the claim later

```json
{
  "claimId": 1,
  "policyNumber": "123123",
  "accidentTime": "2004-10-19T10:23:54",
  "policyHolder": {
    "firstName": "John",
    "lastName": "Cena",
    "emailAddress": "john.cena@mail.com"
  }
}
```

### DOs

1. You can check out the code to your local system and use the IDE that you are comfortable with.
2. The Spring Boot project is provided with the basic structure and some code. You must understand the requirements and implement accordingly. You may choose not to use the existing code, but should not deviate from the requirements mentioned above.
3. Maven is used to do the build for the project. In most cases, you will not have to add any additional dependencies to the project.
4. You are free to refer the documentations and complete the assessment.

### DON'Ts

1. Do not modify the code in the test cases folder. This is used to do the evaluation.
2. Do not change the table design that is provided above.
3. Do not change the request and response specification of the API
4. Do not use different credentials for enabling the security for Create Claim API.

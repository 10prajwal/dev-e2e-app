package com.claim.test.intg.claimcontroller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.claim.test.BaseIntegrationTesting;
import com.fasterxml.jackson.databind.JsonNode;

class TestCreateClaim extends BaseIntegrationTesting {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@DisplayName("createClaimValidDetails: Test when a valid claim is submitted for a policy.")
	void validClaim() {

		JsonNode request = this.readTree("{\r\n" + "    \"accidentTime\": \"2004-10-19T10:23:54\",\r\n"
				+ "    \"policyHolder\" : {\r\n" + "        \"fullName\": \"John\",\r\n"
				+ "        \"emailAddress\" : \"john.cena@mail.com\"\r\n" + "    }\r\n" + "}");

		ResponseEntity<JsonNode> response = testRestTemplate
				.exchange(RequestEntity.post(createURL("/auto-claims")).body(request), JsonNode.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
		assertThat(response.getBody(), is(notNullValue(JsonNode.class)));

		JsonNode claimDto = response.getBody();

		assertAll("Claim Response assertions", () -> assertThat(claimDto.get("claimId"), is(notNullValue())),
				() -> assertThat(claimDto.get("accidentTime").asText(), is(equalTo("2004-10-19T10:23:54"))));

	}

	@Test
	@DisplayName("createClaimValidDetailsAgainstRepo: Test when a valid claim is submitted. Validation against the DB.")
	void validClaimAgainstRepository() {

		JsonNode request = this.readTree("{\r\n" + "    \"accidentTime\": \"2004-10-19T10:23:54\",\r\n"
				+ "    \"policyHolder\" : {\r\n" + "        \"fullName\": \"stella\",\r\n"
				+ "        \"emailAddress\" : \"stella@gmail.com\"\r\n" + "    }\r\n" + "}");

		ResponseEntity<JsonNode> response = testRestTemplate.postForEntity(createURL("/auto-claims"), request,
				JsonNode.class);

		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.CREATED)));
		assertThat(response.getBody(), is(notNullValue()));

		Map<String, Object> result = jdbcTemplate.queryForMap(
				"select EMAIL_ADDRESS, ACCIDENT_TIME, FULL_NAME from auto_insurance_claim where full_name = 'stella'");

		assertAll("Claim Response assertions",
				() -> assertThat(result.get("EMAIL_ADDRESS").toString(), is(equalTo("stella@gmail.com"))),
				() -> assertThat(result.get("ACCIDENT_TIME").toString(), is(equalTo("2004-10-19 10:23:54.0"))),
				() -> assertThat(result.get("FULL_NAME").toString(), is(equalTo("stella"))));

	}

}

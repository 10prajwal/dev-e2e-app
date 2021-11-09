package com.claim.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTesting {
	
	@Autowired
	protected TestRestTemplate testRestTemplate;
	
	@Autowired
	protected ObjectMapper objectMapper;

	@LocalServerPort
	private int port;

	protected String createURL(String uri) {
		return "http://localhost:" + port +"/api/claim-management" + uri;
	}
	
	protected JsonNode readTree(String jsonContent) {
		try {
			return this.objectMapper.readTree(jsonContent);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

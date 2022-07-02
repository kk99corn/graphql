package com.kk99corn.graphql.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HttpRequestController {

	// https://jsonplaceholder.typicode.com/

	@GetMapping("/restTemplateQueryStringTest")
	public HttpEntity<String> restTemplateQueryStringTest(@RequestParam int postId) {
		// https://velog.io/@dogyun-k/RestTemplate%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EC%84%9C%EB%B2%84%EC%99%80-%ED%86%B5%EC%8B%A0%ED%95%98%EA%B8%B0
		// http://daplus.net/java-%EB%A7%A4%EA%B0%9C-%EB%B3%80%EC%88%98%EA%B0%80%EC%9E%88%EB%8A%94-spring-resttemplate-get/

		String url = "https://jsonplaceholder.typicode.com/comments";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("postId", postId);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		//RestTemplate 객체 생성
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(
					builder.toUriString(),
					HttpMethod.GET,
					entity,
					String.class);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
			}
		}

		return response;
	}

	@GetMapping("/restTemplateGetTest")
	public String restTemplateGetTest(@RequestParam int num) {
		// https://qteveryday.tistory.com/110

		String url = "https://jsonplaceholder.typicode.com/todos/{num}";

		Map<String, Object> params = new HashMap<>();
		params.put("num", num);

		//RestTemplate 객체 생성
		RestTemplate restTemplate = new RestTemplate();
		String response = null;
		try {
			response = restTemplate.getForObject(url, String.class, params);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
			}
		}

		return response;
	}

	@GetMapping("/restTemplateQueryStringTest2")
	public HttpEntity<String> restTemplateQueryStringTest2(@RequestParam int postId) {
		String url = "https://jsonplaceholder.typicode.com/comments";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("postId", postId);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		//RestTemplate 객체 생성
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = null;
		try {
			response = restTemplate.exchange(
					builder.toUriString(),
					HttpMethod.GET,
					entity,
					String.class);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
			}
		}

		return response;
	}
}

package com.kk99corn.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomGraphQLException extends RuntimeException implements GraphQLError {
	private Map<String, Object> parameters = new HashMap();

	public CustomGraphQLException(String message) {
		super(message);
	}

	public CustomGraphQLException(String message, Map<String, Object> additionParams) {
		this(message);
		if (additionParams != null) {
			parameters = additionParams;
		}
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		Map<String, Object> customAttributes = new LinkedHashMap<>();
		customAttributes.put("errorCode", "Custom Test Error Code");
		customAttributes.put("errorMessage", "This is Custom Error Message");
		return customAttributes;
	}
}
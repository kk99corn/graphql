package com.kk99corn.graphql.enumd;

import lombok.Getter;

@Getter
public enum ErrorCode {
	// https://bamdule.tistory.com/92
	INVALID_PARAMETER(400, null, "Invalid Request Data"),
	COUPON_EXPIRATION(410, "C001", "Coupon Was Expired"),
	COUPON_NOT_FOUND(404, "C002", "Coupon Not Found");

	private final String code;
	private final String message;
	private final int status;

	ErrorCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}

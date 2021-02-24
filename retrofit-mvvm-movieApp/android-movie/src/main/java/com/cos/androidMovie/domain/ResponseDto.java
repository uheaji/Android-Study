package com.cos.androidMovie.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
	private int statusCode;
	private T data;
}

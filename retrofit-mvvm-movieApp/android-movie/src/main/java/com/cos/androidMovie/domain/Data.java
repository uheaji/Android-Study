package com.cos.androidMovie.domain;

import java.util.List;


@lombok.Data
public class Data {
	private long movie_count;
	private long limit;
	private long page_number;
	private List<Movie> movies;
}

package com.cos.androidMovie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String url;
	private String title;
	private long year;
	private double rating;
	private long runtime;
	@Column(length = 100000)
	private String summary;
	private String medium_cover_image;
}

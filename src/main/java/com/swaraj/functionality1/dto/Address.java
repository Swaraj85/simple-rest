package com.swaraj.functionality1.dto;

import lombok.Data;

@Data
public class Address{
	private String zipcode;
	private Geo geo;
	private String suite;
	private String city;
	private String street;
}
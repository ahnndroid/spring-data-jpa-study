package com.ahnndroid.springdatajpastudy.hibernate_examples.account;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	private String street;
	
	private String city;
	
	private String state;
	
	private String zipCode;
}

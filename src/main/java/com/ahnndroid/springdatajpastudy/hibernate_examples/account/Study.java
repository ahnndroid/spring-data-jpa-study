package com.ahnndroid.springdatajpastudy.hibernate_examples.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Study {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	// 관계의 주인
	@ManyToOne
	private Account owner;
}

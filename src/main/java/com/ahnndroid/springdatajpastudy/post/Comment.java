package com.ahnndroid.springdatajpastudy.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	
	private String content;
	
	// 관계의 주인
	@ManyToOne
	private Post post;
}

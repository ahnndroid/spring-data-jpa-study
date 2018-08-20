package com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ahnndroid.springdatajpastudy.hibernate_examples.post.Post;

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
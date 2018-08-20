package com.ahnndroid.springdatajpastudy.hibernate_examples.post;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String content;
	
	// 어떤 관계의 주인과 연결되는지 선언
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments = new HashSet<Comment>();
}

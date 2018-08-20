package com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.domain.Comment;
import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.domain.Post;
import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.repository.PostRepository;

@Component
@Transactional
public class SpringDataJpaRunner implements ApplicationRunner {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Post post = new Post();
		post.setTitle("Spring Data JPA Example");
		post.setContent("Spring Data JPA Example - Content");
		
		Comment comment1 = new Comment();
		comment1.setContent("Spring Data JPA Example - Comment1");
		
		Comment comment2 = new Comment();
		comment2.setContent("Spring Data JPA Example - Comment2");
		
		postRepository.save(post);
	}

}

package com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findByTitleContains(String title, Pageable pageable);
	
	long countByTitleContains(String title);
}

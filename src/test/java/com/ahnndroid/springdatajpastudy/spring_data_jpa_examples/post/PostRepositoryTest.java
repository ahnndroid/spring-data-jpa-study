package com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.domain.Post;
import com.ahnndroid.springdatajpastudy.spring_data_jpa_examples.post.repository.PostRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepository;
	
	@Test
	public void test001_레파지토리_테스트() {
		// Given
		Post post = new Post();
		post.setTitle("hello spring boot common");		
		assertThat(post.getId()).isNull();
		
		// When
		Post retPost = postRepository.save(post);
		
		// Then
		assertThat(retPost.getId()).isNotNull();
		assertThat(retPost.getTitle()).isEqualTo(post.getTitle());
		
		// When
		List<Post> posts = postRepository.findAll();
		
		// Then
		assertThat(posts.size()).isEqualTo(1);
		assertThat(posts).contains(retPost);
		
		// When
		Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
		
		// Then
		assertThat(page.getTotalElements()).isEqualTo(1);
		assertThat(page.getNumber()).isEqualTo(0);
		assertThat(page.getSize()).isEqualTo(10);
		assertThat(page.getNumberOfElements()).isEqualTo(1);
		
		// When
		postRepository.findByTitleContains("spring", PageRequest.of(0, 10));
		
		// Then
		assertThat(page.getTotalElements()).isEqualTo(1);
		assertThat(page.getNumber()).isEqualTo(0);
		assertThat(page.getSize()).isEqualTo(10);
		assertThat(page.getNumberOfElements()).isEqualTo(1);
		
		// When
		long count = postRepository.countByTitleContains("spring");
		
		// Then
		assertThat(count).isEqualTo(1);
		
	}
	
	
	@Test
	public void test002_Null처리() {
		// When
		Optional<Post> byId = postRepository.findById(100L);
		// Then
		assertThat(byId).isEmpty();
		
		
		// When
		// Spring Data JPA에서는 리턴하는 Collection 객체는 비어있을 경우 null이 아닌 빈 Collection 객체를 리턴해 줌.
		List<Post> posts = postRepository.findAll();
		// Then
		assertThat(posts).isEmpty();
	}
}

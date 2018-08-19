package com.ahnndroid.springdatajpastudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahnndroid.springdatajpastudy.account.Account;
import com.ahnndroid.springdatajpastudy.account.Study;
import com.ahnndroid.springdatajpastudy.post.Comment;
import com.ahnndroid.springdatajpastudy.post.Post;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// EntityManager로부터 Hibernate session 객체 획득
		Session session = entityManager.unwrap(Session.class);
		
		/**
		 * 신규 포스트 및 코멘트 등록
		 */
//		Post post = new Post();
//		post.setTitle("JPA 기본");
//		post.setContent("JPA 기본 관련 내용");
//		
//		Comment comment1 = new Comment();
//		comment1.setContent("JPA 기본 좋아요~");
//		comment1.setPost(post);
//		
//		post.getComments().add(comment1);
//		
//		// Insertion by using Hibernate
//		session.save(post);
		
		/**
		 * 특정 포스트 삭제 (해당 포스트 삭제 시 설정된 Cascade 전략에 의해 연관 코멘트 함께 삭제)
		 */
		Post post = (Post) session.load(Post.class, 5L);
		session.delete(post);
	}

}

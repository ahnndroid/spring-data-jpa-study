package com.ahnndroid.springdatajpastudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setUsername("user1");
		account.setPassword("user1-pw");
		
		// Insertion by using Hibernate
		Session session = entityManager.unwrap(Session.class);
		session.save(account);
		
		// Insertion by using JPA
//		entityManager.persist(account);
	}

}

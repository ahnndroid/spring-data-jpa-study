package com.ahnndroid.springdatajpastudy.hibernate_examples.account;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	
	@Transient
	private String no;
	
	// 관계의 주인쪽에 관계가 맺어졌음을 알려줘야 데이터베이스에 실제 관계가 반영됨.
	@OneToMany(mappedBy = "owner")
	private Set<Study> studies = new HashSet<Study>();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "home_street"))
	})
	private Address address;
	
	public void addStudy(Study study) {
		this.getStudies().add(study);
		study.setOwner(this);
	}
	
	public void removeStudy(Study study) {
		this.getStudies().remove(study);
		study.setOwner(null);
	}
}

package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_BOOT_JPA")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
	private String firstname;
    private String subject;
	
    public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}

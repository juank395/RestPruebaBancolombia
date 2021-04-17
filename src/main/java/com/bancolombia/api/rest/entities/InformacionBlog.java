package com.bancolombia.api.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INFORMACION_BLOG")
public class InformacionBlog {
	
	
	
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="BODY")
	private String body;
	
	@Column(name="USERID")
	private Integer userID;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}

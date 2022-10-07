package com.stepform.stepform.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(unique=true)
	private String title;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Post> posts;
	
	public Category() {
		
	}
	public Category(int id, String title, List<Post> posts) {
		super();
		this.id = id;
		this.title = title;
		this.posts = posts;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}

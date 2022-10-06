/**
 * 
 */
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


/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Entity
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String title;
	private String description;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
    private List<Post> posts;
	
	public Thread() {
		
	}

	public Thread(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}

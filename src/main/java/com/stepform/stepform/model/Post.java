/**
 * 
 */
package com.stepform.stepform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private Date date;
	private String img;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="thread_id")
	private Thread thread;
	
	public Post() {
		
	}
	
	
	public Post(int id, String title, String content, Date date, String img, User user, Thread thread) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.img = img;
		this.user = user;
		this.thread = thread;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}

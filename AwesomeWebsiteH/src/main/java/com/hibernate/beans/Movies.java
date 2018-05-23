package com.hibernate.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Movie")
public class Movies implements Serializable {
	

	
	public Movies(int id, String title, String type) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
	//	this.category = category;
	}
	
	public Movies(String title, String type) {
		super();
		this.title = title;
		this.type = type;
//		this.category = category;
	}

	public Movies() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897553647260794654L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="MovieSequence")
	@SequenceGenerator(allocationSize=1,name="MovieSequence",sequenceName="SQ_Movie_PK")
	@Column(name="Movie_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="TYPE")
	private String type;
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="CATEGORY_ID")
//	private Category category;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
//	public Category getCategory() {
//		return this.category;
//	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", type=" + type + "]";
	}


}
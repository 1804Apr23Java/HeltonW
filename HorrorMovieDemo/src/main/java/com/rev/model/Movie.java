package com.rev.model;

public class Movie {
	private int id;
	private String title;
	private String type;
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
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", type=" + type + "]";
	}
	public Movie(int id, String title, String type) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
	}
	
}

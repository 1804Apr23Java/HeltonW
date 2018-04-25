package com.williamhelton.media;

public class Book extends Media {

	private String author;
	
	public Book() {
		super();
	}
	
	public Book(String author, String title, int yearPublished, String genre) {
		super();
		this.author = author;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ "]";
	}

	
	
}

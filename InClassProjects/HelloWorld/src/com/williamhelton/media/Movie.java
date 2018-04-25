package com.williamhelton.media;

public class Movie extends Media implements Comparable<Movie> {
private String producer;
	
	public Movie() {
		super();
	}
	
	public Movie(String producer, String title, int yearPublished, String genre) {
		super();
		this.producer = producer;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}



	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Movie [producer=" + producer + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ "]";
	}

	@Override
	public int compareTo(Movie m) {
		
		return this.yearPublished.compareTo(m.getYearPublished());
	}
	
	
}

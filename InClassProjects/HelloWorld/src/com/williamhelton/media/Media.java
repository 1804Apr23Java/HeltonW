package com.williamhelton.media;

public abstract class Media {
	
	protected String title;
	protected Integer yearPublished;
	protected String genre;
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
	 * @return the yearPublished
	 */
	public Integer getYearPublished() {
		return yearPublished;
	}
	/**
	 * @param yearPublished the yearPublished to set
	 */
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Media [title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre + "]";
	}
	
}

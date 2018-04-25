package com.williamhelton.comparison;

import java.util.Comparator;

import com.williamhelton.media.Movie;

public class GenreComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie arg0, Movie arg1) {
		return arg0.getGenre().compareTo(arg1.getGenre());
	}

}

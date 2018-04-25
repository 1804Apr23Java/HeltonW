package com.williamhelton.comparison;

import java.util.Comparator;

import com.williamhelton.media.Movie;

public class YearComparator implements Comparator<Movie>{

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getYearPublished().compareTo(o2.getYearPublished());
	}

}

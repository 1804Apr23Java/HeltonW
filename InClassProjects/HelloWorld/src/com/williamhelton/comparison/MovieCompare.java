package com.williamhelton.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.williamhelton.media.Book;
import com.williamhelton.media.Media;
import com.williamhelton.media.Movie;

public class MovieCompare {
	
	public static void main(String[] args) {
		List<Movie> movieList = new ArrayList<Movie>();
		Movie m1 = new Movie("Elie Wies", "Night", 1960, "memoir");
		Movie m2 = new Movie("Ben Carson", "Gifted Hands", 2009, "autobiography");
		Movie m3 = new Movie("Steven Spielberg", "JAWS", 1975, "horror");
		Movie m4 = new Movie("David Latt", "Sharknado", 2013, "science fiction");
		
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		
		System.out.println("Movies before sort: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		//sortWithComparable(movieList);
		sortWithYearComparator(movieList);
		sortWithGenreComparator(movieList);
	}
	
	public static List<Movie> sortWithComparable(List<Movie> movieList) {
		Collections.sort(movieList);
		System.out.println("Movies after sort: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		return movieList;
	}
	
	public static List<Movie> sortWithYearComparator(List<Movie> movieList) {
		Collections.sort(movieList, new YearComparator());
		System.out.println("Movies after sort: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		return movieList;
	}
	
	public static List<Movie> sortWithGenreComparator(List<Movie> movieList) {
		Collections.sort(movieList, new GenreComparator());
		System.out.println("Movies after sort: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		return movieList;
	}
}

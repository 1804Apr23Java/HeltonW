package com.rev.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.rev.model.Movie;

@WebService(endpointInterface ="com.rev.service.BlockBuster")
public class BlockBusterImpl implements BlockBuster{

	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1,"Cabin in the Woods","Good"));
		movieList.add(new Movie(2, "Maximum Overdrive","Bad"));
		movieList.add(new Movie(3, "Scream","Good"));
		return movieList;
		
	}

	public String addMovie(Movie movie) {
		return "Added a movie " + movie.getTitle();
	}

}

package com.rev.service;

import java.util.List;

import javax.jws.WebService;

import com.rev.model.Movie;

@WebService
public interface BlockBuster {
	
	public List<Movie> getAllMovies();
	public String addMovie(Movie movie);

}

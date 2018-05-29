package com.hibernate.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hibernate.beans.Movies;

class TestMovieDaoImpl {

	@Test
	void test() {
		MovieDao movieDao = new MovieDaoImpl();
		Movies movie = new Movies("MovieTitle", "MovieGenre");
		assertEquals(1, movieDao.addMovie(movie));
	}

}

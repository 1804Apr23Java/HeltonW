package com.hibernate.main;

import org.hibernate.Session;

import com.hibernate.beans.Movies;
import com.hibernate.dao.MovieDao;
import com.hibernate.dao.MovieDaoImpl;
import com.hibernate.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();
		System.out.println(s.getStatistics());
		System.out.println(s.isOpen());
		s.close();
		System.out.println(s.isOpen());
		
		MovieDao md = new MovieDaoImpl();
		Movies m = new Movies("Scream", "Good");
		 md.addMovie(m);
		
	}

}



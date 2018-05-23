package com.hibernate.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beans.Movies;
import com.hibernate.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao{

	@Override
	public int addMovie(Movies movie) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(movie);
		tx.commit();
		s.close();
		return result;
	}

	
}

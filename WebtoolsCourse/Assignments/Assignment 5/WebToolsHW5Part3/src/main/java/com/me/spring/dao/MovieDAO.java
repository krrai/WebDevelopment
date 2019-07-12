package com.me.spring.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.me.spring.pojo.Movie;
import com.my.spring.exception.UserException;


public class MovieDAO extends DAO{

	public MovieDAO() {
	}
	
	public Movie addMovie(Movie movie)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			
			getSession().save(movie);
			commit();
			return movie;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public ArrayList<Movie> searchMovie(String type, String query) throws UserException {
		try {
			ArrayList<Movie> movieList = new  ArrayList<Movie>();
			Query q = null;
			begin();
			System.out.println(type + ": "+ query );
			
			if(type.equals("actor")) {
				Criteria criteria = getSession().createCriteria(Movie.class);
				criteria.add(Restrictions.like("actor", "%"+query+"%"));
				movieList = (ArrayList<Movie>) criteria.list();
				System.out.println("size :"+movieList.size());
				//q = getSession().createQuery("from movie where actor = :query");
				//q.setParameter("query", query);
			}
			else if (type.equals("actress")) {
				Criteria criteria = getSession().createCriteria(Movie.class);
				criteria.add(Restrictions.like("actress", "%"+query+"%"));
				movieList = (ArrayList<Movie>) criteria.list();
				System.out.println("size :"+movieList.size());
			}
			else if (type.equals("title")) {
				Criteria criteria = getSession().createCriteria(Movie.class);
				criteria.add(Restrictions.like("title", "%"+query+"%"));
				movieList = (ArrayList<Movie>) criteria.list();
				System.out.println("size :"+movieList.size());
			}
			
			//Movie movie = (Movie) q.uniqueResult();
			
			commit();
			return movieList;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get movie ", e);
		}
	}
	
	
}

package com.me.books.dao;

import org.hibernate.HibernateException;

import com.me.books.pojo.Books;



public class BooksDAO extends DAO{
	
	public boolean addBooks(Books book){
		try{
			begin();
			getSession().save(book);
			commit();
		}
		catch(HibernateException e){
			rollback();
			return false;
		}
		finally{
			close();
		}
		return true;
	}

}

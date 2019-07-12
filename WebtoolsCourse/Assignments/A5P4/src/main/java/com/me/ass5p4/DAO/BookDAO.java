/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.ass5p4.DAO;

import org.hibernate.HibernateException;

import com.me.ass5p4.pojo.Book;

/**
 *
 * @author Jigar
 */
public class BookDAO extends DAO{

	public int addBook(Book book) throws Exception {
		System.out.println("Here");
		try {
			System.out.println("Here B");
            begin();
            getSession().save(book);
            commit();
            System.out.println("Here C");
            return 1;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new Exception("Exception while creating category: " + e.getMessage());
        }
	}
	
	
}

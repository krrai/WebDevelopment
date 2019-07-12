package com.me.ass5p4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.ass5p4.DAO.BookDAO;
import com.me.ass5p4.pojo.Book;

@Controller
@RequestMapping("/**/*")
public class BookController {

	@Autowired
	@Qualifier("bookDAO")
	BookDAO bookDAO;
	
	@RequestMapping(value="/books/addResult.htm", method=RequestMethod.POST)
	public ModelAndView addMovie(HttpServletRequest request) {
		ModelAndView mv = null;
		int count = 0;
		String [] isbns = (String[]) request.getAttribute("isbn");
		String [] titles = (String[]) request.getAttribute("title");
		String [] authors = (String[]) request.getAttribute("authors");
		String [] prices = (String[]) request.getAttribute("price");
		try {				
			for(int i = 0; i < isbns.length; i++) {
				if(!(isbns[i].equals(""))) {
					System.out.println("Here A");
					Book b = new Book();
					System.out.println(isbns[i]);
					b.setIsbn(isbns[i]);
					b.setTitle(titles[i]);
					b.setAuthors(authors[i]);
					b.setPrice(Float.parseFloat(prices[i]));
					System.out.println("A");
					count += bookDAO.addBook(b);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("result", "errorMessage", "error while creating Books");
		}

        mv = new ModelAndView("result","count",count);
		return mv;
	}
	
	@RequestMapping(value="/count.htm", method=RequestMethod.GET)
	public ModelAndView fetchCount(HttpServletRequest request) {
		int count = Integer.parseInt(request.getParameter("count"));
		return new ModelAndView("addBooks","count", count);
	}
	
}

package com.me.spring;

import java.text.DateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.books.dao.BooksDAO;
import com.me.books.pojo.Books;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "books.htm", method = RequestMethod.POST)
	public String requestBooks(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		String userInfo = authorization.substring(5).trim();
		System.out.println(userInfo);
		String nameAndPassword = new String(Base64.getDecoder().decode(userInfo));
		
		System.out.println(nameAndPassword);
		int index = nameAndPassword.indexOf(":");
		//System.out.println(index);
		String user = nameAndPassword.substring(0, index);
		String password = nameAndPassword.substring(index+1);
		
		HttpSession session = request.getSession(true);
		String numberBooks = request.getParameter("input");
        int num = Integer.parseInt(numberBooks);
        
        session.setAttribute("numberBooks", numberBooks);
        if(user.equals("admin")){
			 return "addbooks";
		 }
		 else{
			 return "error";
		 }
		
	}
	
	@RequestMapping(value = "addbooks.htm", method = RequestMethod.POST)
	public String addBooks(HttpServletRequest request) {
		HttpSession session = request.getSession();
        String[] isbn = request.getParameterValues("isbn");
        String[] title = request.getParameterValues("title");
        String[] authors = request.getParameterValues("authors");
        String[] price = request.getParameterValues("price");
        int j=0;
        
        BooksDAO booksDAO = new BooksDAO();
        
        if (isbn != null && title != null && authors != null && price != null) {
            
            for (int i = 0; i < isbn.length; i++) {

                // sanitize inputs then pass
                isbn[i] = isbn[i].replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
                title[i] = title[i].replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
                authors[i] = authors[i].replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
                float priceFlt = Float.parseFloat(price[i]);
                
                Books book = new Books();
                book.setIsbn(isbn[i]);
                book.setTitle(title[i]);
                book.setAuthors(authors[i]);
                book.setPrice(priceFlt);
                
                boolean flag = booksDAO.addBooks(book);
                
                if(flag==true)
                	j++;
   
            }
            System.out.println("Value of J  "+j);
            System.out.println("Value of isbn  "+isbn.length);
            if(j==isbn.length)
            return "success";
            else 
            	return "error";
            
        } else {
            session.setAttribute("errorMsg", "Enter values for all fields");
            return "error" ;
        }
		
	
	}
}

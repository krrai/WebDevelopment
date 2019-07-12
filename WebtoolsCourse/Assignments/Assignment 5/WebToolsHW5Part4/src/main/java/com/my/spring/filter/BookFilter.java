/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.spring.filter;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {

        	String[] isbn = sr.getParameterValues("isbn");
            String[] title = sr.getParameterValues("title");
            String[] authors = sr.getParameterValues("authors");
            String[] price = sr.getParameterValues("price");
            
            
            Pattern r1 = Pattern.compile("\\s");
            Pattern r2 = Pattern.compile("[\'\"]");
            Pattern r3 = Pattern.compile("(and|or|null|not|union|select|from|where|group|order|having|limit|into|file|case)");
            Pattern r4 = Pattern.compile("(--|#|\\/\\*)");

            for(int i = 0; i < isbn.length; i++ ) {
            	if(r1.matcher(isbn[i]).find() || r2.matcher(isbn[i]).find()
            		|| r3.matcher(isbn[i]).find() || r4.matcher(isbn[i]).find()){
            		HttpServletResponse response = (HttpServletResponse) sr1;

                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid isbn provided");
                }
            	}
        	
            for(int i = 0; i < title.length; i++ ) {
        	if(r1.matcher(title[i]).find() || r2.matcher(title[i]).find()
        		|| r3.matcher(title[i]).find() || r4.matcher(title[i]).find()){
        		HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid title provided");
            }
        	}
            
            for(int i = 0; i < authors.length; i++ ) {
            	if(r1.matcher(authors[i]).find() || r2.matcher(authors[i]).find()
            		|| r3.matcher(authors[i]).find() || r4.matcher(authors[i]).find()){
            		HttpServletResponse response = (HttpServletResponse) sr1;

                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid author provided");
                }
            	}
        	
            for(int i = 0; i < price.length; i++ ) {
            	if(r1.matcher(price[i]).find() || r2.matcher(price[i]).find()
            		|| r3.matcher(price[i]).find() || r4.matcher(price[i]).find()){
            		HttpServletResponse response = (HttpServletResponse) sr1;

                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid price provided");
                }
            	}

        }
        
        fc.doFilter(sr, sr1);

    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

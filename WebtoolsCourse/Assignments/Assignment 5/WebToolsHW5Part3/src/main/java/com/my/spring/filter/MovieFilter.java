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

public class MovieFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {

            String movieTitle = sr.getParameter("title");
            String leadActor = sr.getParameter("actor");
            String leadActress = sr.getParameter("actress");
            String genre = sr.getParameter("genre");
            String year = sr.getParameter("year");

            Pattern r1 = Pattern.compile("\\s");
            Pattern r2 = Pattern.compile("[\'\"]");
            Pattern r3 = Pattern.compile("(and|or|null|not|union|select|from|where|group|order|having|limit|into|file|case)");
            Pattern r4 = Pattern.compile("(--|#|\\/\\*)");

            if (r1.matcher(movieTitle).find() || r2.matcher(movieTitle).find()
                    || r3.matcher(movieTitle).find() || r4.matcher(movieTitle).find()) {

                HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie title provided");
            }

            if (r1.matcher(leadActor).find() || r2.matcher(leadActor).find()
                    || r3.matcher(leadActor).find() || r4.matcher(leadActor).find()) {

                HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid lead actor provided");
            }

            if (r1.matcher(leadActress).find() || r2.matcher(leadActress).find()
                    || r3.matcher(leadActress).find() || r4.matcher(leadActress).find()) {

                HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid lead actress provided");
            }

            if (r1.matcher(genre).find() || r2.matcher(genre).find()
                    || r3.matcher(genre).find() || r4.matcher(genre).find()) {

                HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid genre provided");
            }

            if (r1.matcher(year).find() || r2.matcher(year).find()
                    || r3.matcher(year).find() || r4.matcher(year).find()) {

                HttpServletResponse response = (HttpServletResponse) sr1;

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid year provided");
            }
        }
        
        fc.doFilter(sr, sr1);

    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

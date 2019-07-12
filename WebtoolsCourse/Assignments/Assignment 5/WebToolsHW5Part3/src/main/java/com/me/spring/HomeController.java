package com.me.spring;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.MovieDAO;
import com.me.spring.pojo.Movie;
import com.my.spring.exception.UserException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user/*")
public class HomeController {
	
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/user/register", method = RequestMethod.GET)
	public String method() throws Exception{
		
		return "welcome";
	}
	
	
	@RequestMapping(value="/user/login", method = RequestMethod.POST)
	public String loginMethod() throws Exception{
		
		return "success";
	}
	
	@RequestMapping(value="/user/select", method = RequestMethod.POST)
	public String movieShowMethod(HttpServletRequest request) throws Exception{
		String value = request.getParameter("select");
		if(value.equals("browse"))
		return "movieview";
		else if(value.equals("add")) {
			return "addmovie";
		}
		else {
			return "error";
		}
	}
	
	@RequestMapping(value="/user/addmovie", method = RequestMethod.POST)
	public String addMovieMethod(HttpServletRequest request) throws Exception{
		String title = request.getParameter("title");
		String actor = request.getParameter("actor");
		String actress = request.getParameter("actress");
		String genre = request.getParameter("genre");
		String year = request.getParameter("year");
		
		Movie movie =  new Movie();
		
		movie.setTitle(title);
		movie.setActor(actor);
		movie.setActress(actress);
		movie.setGenre(genre);
		movie.setYear(Integer.parseInt(year));
		
		Movie movie2 = movieDAO.addMovie(movie);
		
		return "addsuccess";
	}
	
	@RequestMapping(value="/user/movieresult", method = RequestMethod.POST)
	public String movieResultMethod(HttpServletRequest request) throws Exception{
		
		HttpSession session = (HttpSession) request.getSession();
		try {
		ArrayList<Movie> movieList = movieDAO.searchMovie(request.getParameter("searchby"), request.getParameter("query"));
		if(movieList == null){
			System.out.println("Movie does not exist");
			session.setAttribute("errorMessage", "Movie does not exist");
			return "error";
		}
		
		session.setAttribute("moviename", request.getParameter("query"));
		session.setAttribute("movieList", movieList);
		
		return "result";
		}
		catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while searching movie");
			return "error";
		}
	}
	
	@RequestMapping(value="/error", method = RequestMethod.POST)
	public String loginFailedMethod() throws Exception{
		
		return "error";
	}
}

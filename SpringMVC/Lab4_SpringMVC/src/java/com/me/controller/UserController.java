
package com.me.controller;

import com.me.bean.User;
import com.me.dao.UserDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author krapa
 */
public class UserController extends AbstractController {
    
    public UserController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        // this method is going to return model and view objects.
        
        ArrayList<User> userlist= new UserDAO().getUsers();
               
        // Step1: create obj of model and view.
        ModelAndView mav = new ModelAndView("userview","userlist",userlist);//not actual view page name just a logical name
        
        return mav;// step 2: return model and view object.
    }
    
}

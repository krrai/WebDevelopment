/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.bean.Message;
import com.me.dao.MessageDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author krapa
 */
public class MessageController extends AbstractController {
    
    public MessageController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ArrayList<Message> messagelist= new MessageDAO().getMessages();
               
        // Step1: create obj of model and view.
        ModelAndView mav = new ModelAndView("messageview","messagelist",messagelist);//not actual view page name just a logical name
        
        return mav;
    }
    
}

package com.testwebapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class WelcomeController extends AbstractController{
@Override	
protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	
	ModelAndView modelandview = new ModelAndView("welcome");
	modelandview.addObject("welcomeMessage", "Welcome to the test application");
	return modelandview;
}

}

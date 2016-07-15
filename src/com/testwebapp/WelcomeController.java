package com.testwebapp;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testwebapp.Serviceone;
import com.testwebapp.Servicetwo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WelcomeController{
	private static Serviceone servone = new Serviceone();
	private static Servicetwo servtwo = new Servicetwo();

@RequestMapping(value="/", method = RequestMethod.GET)
public String welcome(ModelMap model){
	model.addAttribute("welcomeMessage", "Welcome to test web app!");
	model.addAttribute("show", "Search for links!");
	return "welcome";
}

@RequestMapping(value = "/search/", method = RequestMethod.POST)
public @ResponseBody String Search(@RequestParam ("key") String key)
{
    System.out.println( key );
    servone.createraw();
	ObjectMapper mapper = new ObjectMapper();
	String data = null;
	try {
		data = mapper.writeValueAsString(servone.fetchlinks(key));
		System.out.println(mapper.writeValueAsString(servone.fetchlinks(key)));

	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
    
}

@RequestMapping(value = "/links/", method = RequestMethod.POST)
public @ResponseBody String searchDetails( @RequestParam ("link") String link)
{
	servtwo.create();
	ObjectMapper mapper = new ObjectMapper();
	String data = null;
	try {
		data = mapper.writeValueAsString(servtwo.fetchdetails(link));
		System.out.println(data);

	} catch (JsonGenerationException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(data);
	return data;
}
}
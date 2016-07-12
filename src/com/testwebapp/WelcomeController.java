package com.testwebapp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testwebapp.Serviceone;
import com.testwebapp.Servicetwo;


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

@RequestMapping(value="/{key}", method = RequestMethod.GET)
public String Welcome(ModelMap model, @PathVariable String key){
	model.addAttribute("welcomeMessage", "Welcome to test web app!");
	model.addAttribute("show", "Showing search results for '"+key+"'");
	System.out.println(key);
	servone.createraw();
	servtwo.create();
	List links = servone.fetchlinks(key);
	  String [] linker = (String[]) links.toArray(new String[links.size()]);
	int length = linker.length;
	String data = "{";
	int i = 0;
	while(i<length){
		data += "\""+i+"\":"+"\""+linker[i]+"\"";
		i++;
		if(i!=length)
			data+=",";
	}
	data+="}";
	System.out.println(data);
	model.addAttribute("links", data);
	return "welcome";
}

@RequestMapping(value="/{key}/{link}", method = RequestMethod.GET)
public String Welcome(ModelMap model, @PathVariable String key, @PathVariable String link){
	model.addAttribute("welcomeMessage", "Welcome to test web app!");
	model.addAttribute("show", "Showing search results for '"+key+"'");
	servone.createraw();
	servtwo.create();
	List links = servone.fetchlinks(key);
	  String [] linker = (String[]) links.toArray(new String[links.size()]);
	int length = linker.length;
	String data = "{";
	int i = 0;
	while(i<length){
		data += "\""+i+"\":"+"\""+linker[i]+"\"";
		i++;
		if(i!=length)
			data+=",";
	}
	data+="}";
	model.addAttribute("links", data);
	model.addAttribute("key", key);
	System.out.println(link);
	model.addAttribute("detail", servtwo.fetchdetails(link));
	return "welcome";
}

}
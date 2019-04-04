package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller to show the initail HTML form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to proces the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new a controller method to read from data and
	// and data to the model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();

		String result = "Yo! " + theName;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

		// read the request parameter from HTML form
		theName = theName.toUpperCase();

		String result = "Hey My Friend " + theName;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
}

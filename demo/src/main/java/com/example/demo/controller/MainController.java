package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("id")
public class MainController {

	@GetMapping("hello")
	public String displayHello()
	{ 
		System.out.println("Inside hello");
		return "hello";
	}
	
	@GetMapping("index1")
	public String displayIndex()
	{
		System.out.println("Inside index");
		return "index";
	}
	
	@GetMapping("showEmployee")
	public String showEmployee()
	{
		System.out.println("Inside showEmployee");
		return "EmployeeForm";
	}
	
	@PostMapping("processemployee")
	public String processemployee(@RequestParam("name") String name , @RequestParam("id") String id , Model model)
	{
		System.out.println("Inside processemployee");
		System.out.println("Id is "+id);
		model.addAttribute("id", id);
		return "sessiondatadisplay";
	}
	
	
	@PostMapping("processsessiondata")
	public String processsessiondata( @SessionAttribute("id") String id)
	{
		System.out.println("Inside processsessiondata");
		System.out.println("Session Attribute Id is "+id);		
		return "sessiondatadisplay";
	}
	
	
}

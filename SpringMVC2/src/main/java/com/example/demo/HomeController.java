package com.example.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Alien;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void Modeldata(Model m) {
		m.addAttribute("name", "sai kumar");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("nice");
		return "index";
		
	}
	
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		int k=i+j;
		mv.addObject("result", k);
		
		return mv;
		
	}
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a) {
		System.out.println(a);
		System.out.println(a.getId());
		System.out.println(a.getName());
		return "result";
		
	}
	
	/*
	 * @RequestMapping("add") public String add(HttpServletRequest req) { int
	 * i=Integer.parseInt(req.getParameter("num1")); int
	 * j=Integer.parseInt(req.getParameter("num2")); int k=i+j;
	 * 
	 * HttpSession s=req.getSession(); s.setAttribute("result", k);
	 * 
	 * return "result.jsp";
	 * 
	 * }
	 */
	}

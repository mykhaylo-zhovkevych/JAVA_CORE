package com.mz.project04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
// first request will go to the dispatcher-controller and from there it will be redirected to the particular controller
	@RequestMapping("/")
	public String home() {
		// tomcat jasper converts jsp and redirect me to the page 
		return "index.jsp";
	}
	
	// when the add request will be called the method add will be called
	@RequestMapping("add")
	// req object that is not self declared thanks to the spring that this object recives the data
	public String add(HttpServletRequest req) {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int num3 = i + j;
		HttpSession session = req.getSession();
		session.setAttribute("num3", num3);
		
		
		// Through url passing return "result.jsp?num3=" +num3;
		return "result.jsp";
		// 2:22:49 / 14:34:41 https://www.youtube.com/watch?v=Jl9OKQ92SJU&list=PLsyeobzWxl7q6oUFts2erdot6jxF_lisP&index=10
	}
}

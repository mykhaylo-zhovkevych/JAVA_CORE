package com.mz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//lecture 14 the Servlet Annotation 
@WebServlet("/SqServletSession")
public class SqServletSession extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
//		HttpSession session = req.getSession();
		
		// the values can not be fetched when this is gone
		// the value can be fetched only when the vales do exist in this current session.
		// session.removeAttribute("k");
		
		// attribute means will the object be returned
//		int k = (int)session.getAttribute("k");
		
		//  here starts the cookies part of managing the data distribution 
		int k = 0;
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c : cookies)
		{
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
	
		
		k = k * k;
		
		// HttpSession is interface 
		
		
		
		PrintWriter out = res.getWriter();
		out.println("Result is" + k);
		
		System.out.print("this is working!");
	}
	
}
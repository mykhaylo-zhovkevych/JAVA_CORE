package com.mz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet // making this class a sarvlet class and this my class have to gave service method that look for request and response
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		int i = Integer.parseInt(req.getParameter("num1")); //getPatameter must be converted from String to the int
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		// req.setAttribute("k", k); sending to another servlet
		
		res.sendRedirect("sq?k="+k);
	}
}

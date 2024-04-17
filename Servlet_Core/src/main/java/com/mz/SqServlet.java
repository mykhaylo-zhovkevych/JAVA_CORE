//package com.mz;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class SqServlet
// */
//@WebServlet("/SqServlet")
//public class SqServlet extends HttpServlet {
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
//		
//		int k = Integer.parseInt(req.getParameter("k"));
//		k = k * k;
//		
//		PrintWriter out = res.getWriter();
//		out.println("Result is" + k);
//		
//		System.out.print("this is working!");
//	}
//	
//}
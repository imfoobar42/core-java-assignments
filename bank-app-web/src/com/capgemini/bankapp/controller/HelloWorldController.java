package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloWorld", loadOnStartup =1, urlPatterns= {"/hello","/helloWorld","/login"})
public class HelloWorldController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWorldController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//I want to get credentials
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		RequestDispatcher dispatcher= null;
		if(username.equals("root")&& password.equals("root@123")) {
//			out.println("<h2> Login successfully. Welcome "+username+ "</h2>");
			 dispatcher = req.getRequestDispatcher("success.html");
			}
		else {
			dispatcher = req.getRequestDispatcher("error.html");
		}
//			out.println("<h2> Login Unsuccessful</h2>");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello World!!!!"); // This prints Hello World !!! on server Console
		PrintWriter out = response.getWriter();
		out.println("Hello World!");
		out.close();
	}
}

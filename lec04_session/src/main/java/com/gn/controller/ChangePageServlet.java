package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Cookie cookie = new Cookie("visit_count", "aas");
		
		cookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cookie);
		response.sendRedirect("/views/countPage.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

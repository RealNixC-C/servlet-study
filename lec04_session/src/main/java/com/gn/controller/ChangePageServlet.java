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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		int count = 1;

		System.out.println(cookies.length);
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("visit_count".equals(c.getName())) {
					count = Integer.parseInt(c.getValue());
					count++;
				}
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
			}
		}


		Cookie cookie = new Cookie("visit_count", String.valueOf(count));

		cookie.setMaxAge(60 * 60 * 24);

		request.setAttribute("count", count);
		
		response.addCookie(cookie);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/countPage.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

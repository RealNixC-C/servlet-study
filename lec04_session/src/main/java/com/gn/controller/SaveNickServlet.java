package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveNick")
public class SaveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveNickServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String nickName = request.getParameter("saveNick");
		
		Cookie cookie = new Cookie("nickname01", nickName);
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
		response.sendRedirect("/views/cookiePage.jsp");
	}

}

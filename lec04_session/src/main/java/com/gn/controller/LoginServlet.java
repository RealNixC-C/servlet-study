package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();			
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if (userId.equals(correctId) && userPw.equals(correctPw)) {
			System.out.println("로그인 성공");
			
			Account account = new Account();
			account.setName(name);
			System.out.println(account.getName());
			account.setId(userId);
			System.out.println(account.getId());
			
			session.setAttribute("account", account);
			session.setMaxInactiveInterval(60 * 30);
		} 
		response.sendRedirect("/");

		
		
	}

}

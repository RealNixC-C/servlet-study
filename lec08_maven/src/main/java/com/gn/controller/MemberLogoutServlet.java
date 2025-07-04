package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memberLogout")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 객체 가져오기
		HttpSession session = request.getSession(false);
		
		// 2. 특정 속성만 제거
		if(session != null) {
			session.removeAttribute("loginMember");
			
		}
		
		// 3. 로그아웃 후 메인 화면(루트화면)으로 이동
		response.sendRedirect(request.getContextPath()+"/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제하고 싶은 쿠키와 같은 key값으로 쿠키 생성
		Cookie c = new Cookie("user_id", "");
		// 2. 유지시간을 0초로 변경 (즉시 삭제하기 위함)
		c.setMaxAge(0);
		// 3. 응답에 추가
		response.addCookie(c);
		// 4. 새로운 요청 발생 (루트패스)
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

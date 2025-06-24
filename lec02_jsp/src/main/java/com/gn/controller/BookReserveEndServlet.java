package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book_reserve_end")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReserveEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		String bookName = request.getParameter("book_name");
		int period = Integer.parseInt(request.getParameter("borrow_period")); 
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(bookName);
		System.out.println(period);
		
		String bookTitle = "";
		int bookPrice = 0;
		
		switch (bookName) {
		case "1":
			bookTitle = "자바 프로그래밍 입문";
			bookPrice = 1500 + 500 * (period);
			break;
		case "2":
			bookTitle = "웹 개발의 기초";
			bookPrice = 1800 + 500 * (period);
			break;
		case "3":
			bookTitle = "데이터베이스 시스템";
			bookPrice = 2000 + 500 * (period);
			break;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("period", period);
		request.setAttribute("bookPrice", bookPrice);
		
		RequestDispatcher view = request.getRequestDispatcher("views/book/confirm.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

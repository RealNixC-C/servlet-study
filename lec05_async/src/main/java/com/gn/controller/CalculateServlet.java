package com.gn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
		
		double avg = kor + eng + math / 3.0;
		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			System.out.println("합격");
			out.println("합격");
		} else {
			System.out.println("불합격");
			out.println("불합격");
		}
		
	}

}

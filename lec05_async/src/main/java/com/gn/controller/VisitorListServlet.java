package com.gn.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VisitorList")
public class VisitorListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisitorListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String visitorName = request.getParameter("visitorName");
		String visitorMsg = request.getParameter("visitorMsg");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String date = now.format(formatter);
		
		System.out.println(date);

		JSONObject obj = new JSONObject();
		
				
		if(!(visitorName.isEmpty() && visitorMsg.isEmpty())) {
			System.out.println("obj객체 내용 추가");
			obj.put("visitorName", visitorName);
			obj.put("visitorMsg", visitorMsg);
			obj.put("nowDate", date);
		}
		System.out.println(obj);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
		System.out.println("front로 보냄");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

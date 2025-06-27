package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "자바의 정석", "김철수"));
		list.add(new Book(2, "스프링 입문", "이순신"));
		list.add(new Book(3, "MySQL 실습", "홍길동"));
		list.add(new Book(4, "웹 개발 가이드", "유관순"));
		
		String keyword = request.getParameter("keyword");
		
		JSONArray arr = new JSONArray();
		
		for (Book l : list) {
			if (l.getTitle().contains(keyword)) {
				JSONObject obj = new JSONObject();
				obj.put("no", l.getNo());
				obj.put("title", l.getTitle());
				obj.put("author", l.getAuthor());
				arr.add(obj);
			}
		}
		
		
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		
		System.out.println("배열생성완료");
		System.out.println("사이즈" + arr.size());
		
		response.setContentType("application/json; charset-UTF-8");
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

package com.gn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderFrm")
public class PizzaorderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaorderEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		
		String size = "";
		int price = 0;
		
		switch (request.getParameter("size")) {
		case "1":
			size = "small";
			price = 15900;
			break;
		case "2":
			size = "medium";
			price = 21000;
			break;
		case "3":
			size = "large";
			price = 27900;
			break;

		}
		
		String[] toppingsArr = request.getParameterValues("topping");
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "shrimp");
		map.put("2", "sweet");
		map.put("3", "potato");
		map.put("4", "pine");
		
		String toppings = "";
		
		for (String topping : toppingsArr) {
			toppings += "<li>" + map.get(topping) + "</li>";
			
			if(topping.equals("1")) {
				price += 2000;
			} else {
				price += 1000;
			}
			
			
		}
		String deliveryTime = request.getParameter("delivery_time");
		
		System.out.println(userName);
		System.out.println(userPhone);
		System.out.println(userEmail);
		System.out.println(size);
		System.out.println(toppings);
		System.out.println(deliveryTime);
		System.out.println(price);
		
		
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("size", size);
		request.setAttribute("toppings", toppings);
		request.setAttribute("deliveryTime", deliveryTime);
		request.setAttribute("price", price);
		
		RequestDispatcher views = request.getRequestDispatcher("views/pizza/result.jsp");
		views.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		String productCode = request.getParameter("product");
		
		List<Product> myCartList = new ArrayList<>();
		
		if (session != null) {
			List<Product> productList =(ArrayList<Product>)session.getAttribute("productList");
			if(productList != null) {
				for (Product p : productList) {
					String code = String.valueOf(p.getCode());
					if (code.equals(productCode)) {
						myCartList.add(p);
						session.setAttribute("myList", myCartList);
						session.setMaxInactiveInterval(60 * 30);
						System.out.println("추가됨");
					}
				}
			}
		}
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

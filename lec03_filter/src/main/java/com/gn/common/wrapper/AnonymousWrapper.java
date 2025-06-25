package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		
		String value = super.getParameter(name);
		if (name != null && "writer".equals(name)) {
			if (value != "익명") {
				return "익명";
			}
		}
		return value;
	}
	
}

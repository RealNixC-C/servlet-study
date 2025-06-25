package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class TitlePrefixWrapper extends HttpServletRequestWrapper{

	public TitlePrefixWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		
		String value = super.getParameter(name);
		if("title".equals(name) && value != null) {
			return "[공지]" + value;
		}
		return value;
	}
	
}

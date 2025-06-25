package com.gn.common.filter;

import java.io.IOException;

import com.gn.common.wrapper.MsgRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MsgFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("[MsgFilter]요청 가로챔");
		// ServletRequest는 HttpServletRequest의 부모
		MsgRequestWrapper wrappedRequest = new MsgRequestWrapper((HttpServletRequest) arg0);
		
		arg2.doFilter(wrappedRequest, arg1);
		System.out.println("[MsgFilter]응답 가로챔");
	}

	
	
}

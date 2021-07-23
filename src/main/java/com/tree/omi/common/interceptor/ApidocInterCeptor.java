package com.tree.omi.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tree.omi.common.annotation.ApidocAnnotation;

public class ApidocInterCeptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		ApidocAnnotation apidoc = handlerMethod.getMethodAnnotation(ApidocAnnotation.class);
		
		if(apidoc == null) {
			return true;
		} else if(apidoc.isCheck()) {
			System.out.println("intercept!!");
		}
		
		
		return true;
	}
}

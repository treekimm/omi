package com.tree.omi.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tree.omi.common.annotation.ApidocAnnotation;

public class ApidocInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		ApidocAnnotation apidoc = handlerMethod.getMethodAnnotation(ApidocAnnotation.class);
		System.out.println(apidoc);
		
		if(apidoc == null) {
			System.out.println("no annotation");
			return true;
		} else if(apidoc.isCheck()) {
			System.out.println("intercept!!");
		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}

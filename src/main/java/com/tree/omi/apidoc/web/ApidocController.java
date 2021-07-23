package com.tree.omi.apidoc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.common.annotation.ApidocAnnotation;
import com.tree.omi.common.base.BaseController;

@Controller("ApidocController")
public class ApidocController extends BaseController{
	
	@ApidocAnnotation
	@RequestMapping(value = "/apidoc")
	public ModelAndView apidoc(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView)throws Exception {
		
		
		
		return responseView(request, "/apidoc/apidoc");
	}
	
}

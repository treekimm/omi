package com.tree.omi.common.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public abstract class BaseController {
	public ModelAndView responseView(HttpServletRequest request, BaseDTO baseDTO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		mv.addObject("result",baseDTO);
		
		return mv;
	}
	public ModelAndView responseView(HttpServletRequest request, String view) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		
		return mv;
	}
}
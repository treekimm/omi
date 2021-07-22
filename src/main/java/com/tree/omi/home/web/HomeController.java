package com.tree.omi.home.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.common.base.BaseController;
import com.tree.omi.home.vo.HomeRequestDTO;
import com.tree.omi.home.vo.HomeResponseDTO;

@Controller("HomeController")
public class HomeController extends BaseController{

	@RequestMapping("/")
	public ModelAndView home (HomeRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
		
		HomeResponseDTO resultDTO = new HomeResponseDTO();
		
		return responseView(request, "/home");
	}
}

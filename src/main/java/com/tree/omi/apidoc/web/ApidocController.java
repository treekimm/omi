package com.tree.omi.apidoc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.apidoc.dto.ApiNameResponseDTO;
import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.base.BaseController;

@Controller
public class ApidocController extends BaseController{

	@Resource(name="ApidocService")
	private ApidocService apidocService;
	
	@RequestMapping(value="/apidoc")
	public ModelAndView Apidoc (HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		
		
		return responseView(request, "/apidoc/apidoc");
	}
	
	@RequestMapping(value = "/apidoc/getApiName")
	public ModelAndView ApiName (HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApiNameResponseDTO result = new ApiNameResponseDTO();
		
		result.setName(apidocService.getApinName(request));
		
		return responseView(request, result);
	}
	
}

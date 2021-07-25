package com.tree.omi.apidoc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.apidoc.dto.ApidocResponseDTO;
import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.annotation.ApidocAnnotation;
import com.tree.omi.common.base.BaseController;

@ApidocAnnotation
@Controller("ApidocController")
public class ApidocController extends BaseController{
	
	@Resource(name = "ApidocService")
	private ApidocService apidocService;
	
	
	@RequestMapping(value = "/apidoc")
	public ModelAndView apidoc(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView)throws Exception {
		apidocService.printApiList();

		return responseView(request, "/apidoc/apidoc");
	}
	
	@RequestMapping(value = "/getApidocList")
	public ModelAndView getApidocList(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApidocResponseDTO resultDTO = new ApidocResponseDTO();
		
		resultDTO.setApiList(apidocService.getApiName());
		
		return responseView(request, resultDTO);
	}
}

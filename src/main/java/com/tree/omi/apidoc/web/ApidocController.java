package com.tree.omi.apidoc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.apidoc.dto.ApiInfoResponseDTO;
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

		return responseView(request, "/apidoc/apidoc");
	}
	
	@RequestMapping(value = "/getApidocList")
	public ModelAndView getApidocList(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApidocResponseDTO resultDTO = new ApidocResponseDTO();
		
		resultDTO.setApiList(apidocService.getApiName());
		
		return responseView(request, resultDTO);
	}
	
	@RequestMapping(value = "/getApiInfo")
	public ModelAndView getApiInfo(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApiInfoResponseDTO resultDTO = new ApiInfoResponseDTO();
		
		List<String> paramList = apidocService.getApiName();
		
		System.out.println("====================apiNamList size : "+ paramList.size());
		
		resultDTO.setResult(apidocService.getApiInfoList(paramList));
		
		return responseView(request, resultDTO);
	}
}

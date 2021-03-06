package com.tree.omi.testapidoc.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.common.annotation.ApidocAnnotation;
import com.tree.omi.common.base.BaseController;
import com.tree.omi.testapidoc.dto.ApiInfoResponseDTO;
import com.tree.omi.testapidoc.dto.ApidocResponseDTO;
import com.tree.omi.testapidoc.service.ApidocService;

@ApidocAnnotation
public class ApidocController extends BaseController{
	
	@Resource(name = "ApidocService")
	private ApidocService apidocService;
	
	
	public ModelAndView apidoc(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView)throws Exception {

		return responseView(request, "/apidoc/apidoc");
	}
	
	public ModelAndView getApidocList(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApidocResponseDTO resultDTO = new ApidocResponseDTO();
		
		resultDTO.setApiList(apidocService.getApiName());
		
		return responseView(request, resultDTO);
	}
	
	public ModelAndView getApiInfo(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApiInfoResponseDTO resultDTO = new ApiInfoResponseDTO();
		
		List<String> apiPathList = apidocService.getApiName();
		List<String> apiList = new ArrayList<String>() ;
		for(String a : apiPathList) {
			apiList.add(a.split("\\.")[a.split("\\.").length-1].toString());
		}
		
		List<String> dtoList = apidocService.getDtoName();
		
		resultDTO.setApiNameList(apiList);
		resultDTO.setDtoNameList(dtoList);
		resultDTO.setResultMap(apidocService.getApiInfoList(dtoList));
		
		return responseView(request, resultDTO);
	}
}

package com.tree.omi.apidoc.web;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.apidoc.dto.ApiInfoResponseDTO;
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
		List<String> nameList = apidocService.getControllerList(request);
		
		List<String> resultList = new ArrayList<String>();
		for(String name : nameList) {
			resultList.add(name.split("\\.")[name.split("\\.").length-1].toString());
		}
		
		result.setName(resultList);
		
		return responseView(request, result);
	}
	
	@RequestMapping(value = "/apidoc/getApiInfo")
	public ModelAndView ApiInfo(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ApiInfoResponseDTO responseDTO = new ApiInfoResponseDTO();
		List<HashMap<String,HashMap<String,List<HashMap<String,String>>>>> result = new ArrayList<HashMap<String,HashMap<String,List<HashMap<String,String>>>>>();
		HashMap<String,HashMap<String,List<HashMap<String,String>>>> apiMap = new HashMap<String,HashMap<String,List<HashMap<String,String>>>>();
		HashMap<String,List<HashMap<String,String>>> paramMap = new HashMap<String,List<HashMap<String,String>>>();
		List<HashMap<String,String>> fieldList = new ArrayList<HashMap<String,String>>();
		
		System.out.println(apidocService.getControllerList(request).size());
		
		for(String controller : apidocService.getControllerList(request)) {
			System.out.println(controller);
			for(Method api : apidocService.getApiList(controller)) {
				System.out.println(api);
				for(Class paramClass : apidocService.getApiParamList(api)) {
					System.out.println(paramClass);
					if(paramClass.getName().contains("RequestDTO") || paramClass.getName().contains("ResponseDTO")) {
						fieldList = apidocService.getDtoField(paramClass);
						paramMap.put(paramClass.toString(), fieldList);
						apiMap.put(api.toString(), paramMap);
						
						result.add(apiMap);
						
						fieldList.clear();
						paramMap.clear();
						apiMap.clear();
					}
				}
			}
		}
		
		responseDTO.setResult(result);
		
		return responseView(request, responseDTO);
	}
	
}

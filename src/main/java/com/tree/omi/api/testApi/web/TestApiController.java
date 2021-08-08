package com.tree.omi.api.testApi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.common.base.BaseController;
import com.tree.omi.test.vo.TestRequestDTO;
import com.tree.omi.test.vo.TestResponseDTO;

@Controller
public class TestApiController extends BaseController{
	
	@RequestMapping(value = "/api/testApi")
	public ModelAndView testApi(TestRequestDTO requestDTO, TestResponseDTO responseDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return responseView(request,responseDTO);
	}
}

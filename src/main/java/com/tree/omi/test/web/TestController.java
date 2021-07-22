package com.tree.omi.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.common.base.BaseController;
import com.tree.omi.test.vo.TestRequestDTO;
import com.tree.omi.test.vo.TestResponseDTO;

@Controller("TestController")
public class TestController extends BaseController{

	@RequestMapping(value = "/test")
	public @ResponseBody ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TestResponseDTO responseDTO = new TestResponseDTO();
		
		responseDTO.setText("init");
		System.out.println(responseDTO.getText());
		return responseView(request,responseDTO);
	}
	
}

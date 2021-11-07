package com.tree.omi.apidoc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tree.omi.apidoc.dto.ControllerListResponseDTO;
import com.tree.omi.apidoc.dto.ControllerListSubResponseDTO;
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
	
	@RequestMapping(value = "/apidoc/getControllerList")
	public ModelAndView getControllerInfo (HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		ControllerListResponseDTO result = new ControllerListResponseDTO();
		List<ControllerListSubResponseDTO> controllerList = apidocService.getControllerList(request);
		
		result.setResult(controllerList);
		
		return responseView(request, result);
	}
	
	@RequestMapping(value = "/apidoc/getApiInfo")
	public ModelAndView ApiInfo(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws Exception {
		
		/*
		 * ApiInfoResponseDTO responseDTO = new ApiInfoResponseDTO();
		 * List<HashMap<String,HashMap<String,List<HashMap<String,String>>>>> result =
		 * new
		 * ArrayList<HashMap<String,HashMap<String,List<HashMap<String,String>>>>>();
		 * HashMap<String,HashMap<String,List<HashMap<String,String>>>> apiMap = new
		 * HashMap<String,HashMap<String,List<HashMap<String,String>>>>();
		 * HashMap<String,List<HashMap<String,String>>> paramMap = new
		 * HashMap<String,List<HashMap<String,String>>>(); List<HashMap<String,String>>
		 * fieldList = new ArrayList<HashMap<String,String>>();
		 * 
		 * System.out.println(apidocService.getControllerList(request).size());
		 */
		
		/*
		 * for(String controller : apidocService.getControllerList(request)) {
		 * System.out.println(controller); for(Method api :
		 * apidocService.getApiList(controller)) { System.out.println(api); for(Class
		 * paramClass : apidocService.getApiParamList(api)) {
		 * System.out.println(paramClass);
		 * if(paramClass.getName().contains("RequestDTO") ||
		 * paramClass.getName().contains("ResponseDTO")) { fieldList =
		 * apidocService.getDtoField(paramClass); paramMap.put(paramClass.toString(),
		 * fieldList); apiMap.put(api.toString(), paramMap);
		 * 
		 * result.add(apiMap);
		 * 
		 * fieldList.clear(); paramMap.clear(); apiMap.clear(); } } } }
		 */
		
		/* responseDTO.setResult(result); */
		
		/* return responseView(request, responseDTO); */
		return null;
	}
	
	/*
	 * @RequestMapping(value = "/apidoc/getControllerList") public ModelAndView
	 * controllerList(HttpServletRequest request, HttpServletResponse response,
	 * ModelAndView modelAndView) throws Exception { ApiNameResponseDTO responseDTO
	 * = new ApiNameResponseDTO();
	 * 
	 * List<String> fileList = new ArrayList<String>();
	 * 
	 * String dir = "D:\\dev\\workspace\\omi\\src\\main\\java\\com\\tree\\omi\\api";
	 * File list = new File(dir); for(File rf : list.listFiles()) { for(File cf :
	 * rf.listFiles()) { if(cf.toString().indexOf("web") != -1) { for(File f :
	 * cf.listFiles()) { System.out.println(f.toString()); } } } }
	 * //System.out.println(list.listFiles().toString());
	 * 
	 * return responseView(request, responseDTO); }
	 */
	
}

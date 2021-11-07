package com.tree.omi.apidoc.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Service;

import com.tree.omi.apidoc.dto.ControllerListResponseDTO;
import com.tree.omi.apidoc.dto.ControllerListSubResponseDTO;
import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.filter.RealApidocFilter;

@Service("ApidocService")
public class ApidocServiceImpl implements ApidocService{

	@Override
	public List<Method> getApiList(String className) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		List<Method> apiList = new ArrayList<Method>();
		
			Class clzz = Class.forName(className);
			Method[] methods = clzz.getDeclaredMethods();
			
			for(Method method : methods) {
				apiList.add(method);
			}
		return apiList;
	}
	
	@Override
	public List<ControllerListSubResponseDTO> getControllerList(HttpServletRequest request) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		RealApidocFilter controllerFilter = new RealApidocFilter("ANNOTATION","CONTROLLER");
		RealApidocFilter classFilter = new RealApidocFilter("CLASS");
		
		scanner.addExcludeFilter(controllerFilter);
		scanner.addExcludeFilter(classFilter);
		
		Set<BeanDefinition> classSet = scanner.findCandidateComponents("/com/tree/omi/api"); // basepackage 하위의 모든 패키지를 대상으로 읽어온다
		
		ControllerListResponseDTO result = new ControllerListResponseDTO();
		
		List<ControllerListSubResponseDTO> controllerNameList = new ArrayList<ControllerListSubResponseDTO>();
		
		String controllerName = "";
		String controllerPath = "";
		for(BeanDefinition clss : classSet) {
			ControllerListSubResponseDTO tempControllerInfo = new ControllerListSubResponseDTO();
			
			controllerPath = clss.getBeanClassName();
			controllerName = controllerPath.split("\\.")[controllerPath.split("\\.").length-1].toString();  
			
			tempControllerInfo.setControllerName(controllerName);
			tempControllerInfo.setControllerPath(controllerPath);
			
			controllerNameList.add(tempControllerInfo);
			
			controllerPath = "";
			controllerName = "";
		}
		
		return controllerNameList;
	
	}
	
	@Override
	public List<Class> getApiParamList(Method method) throws Exception {
		
		List<Class> resultList = new ArrayList<Class>();
		
		for(Parameter param : method.getParameters()) {
			resultList.add(param.getType());
		}
		
		return resultList;
	}

	@Override
	public List<HashMap<String,String>> getDtoField(Class dto) throws Exception {
		
		HashMap<String,String> tempMap = new HashMap<String,String>();
		List<HashMap<String,String>> resultList = new ArrayList<HashMap<String,String>>();
		
		for(Field field : dto.getDeclaredFields()) {
			System.out.println("filed name : " + field.getName() + "filed type : " + field.getType().toString());
			tempMap.put(field.getName(), field.getType().toString());
			resultList.add(tempMap);
			tempMap.clear();
		}
		
		return resultList;
	}


}

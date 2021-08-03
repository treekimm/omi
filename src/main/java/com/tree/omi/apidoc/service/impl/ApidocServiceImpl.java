package com.tree.omi.apidoc.service.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Service;

import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.filter.RealApidocFilter;

@Service("ApidocService")
public class ApidocServiceImpl implements ApidocService{

	@Override
	public List<String> getApiList(HttpServletRequest request) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		RealApidocFilter controllerFilter = new RealApidocFilter("ANNOTATION","CONTROLLER");
		RealApidocFilter classFilter = new RealApidocFilter("CLASS");
		
		scanner.addExcludeFilter(controllerFilter);
		scanner.addExcludeFilter(classFilter);
		
		Set<BeanDefinition> classSet = new HashSet();
		
		classSet = scanner.findCandidateComponents("/com/tree/omi"); // basepackage 하위의 모든 패키지를 대상으로 읽어온다
		
		List<String> apiNameList = new ArrayList<String>();
		
		for(BeanDefinition clss : classSet) {
			Class clzz = Class.forName(clss.getBeanClassName());
			Method[] methods = clzz.getDeclaredMethods();
			
			for(Method method : methods) {
				apiNameList.add(method.getName());
				for(Parameter param : method.getParameters()) {
					apiNameList.add(param.getType().toString());
				}
				
			}
		}
		return apiNameList;
	}
	
	@Override
	public List<String> getControllerList(HttpServletRequest request) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		RealApidocFilter controllerFilter = new RealApidocFilter("ANNOTATION","CONTROLLER");
		
		scanner.addExcludeFilter(controllerFilter);
		
		Set<BeanDefinition> classSet = new HashSet();
		
		classSet = scanner.findCandidateComponents("/com/tree/omi/api"); // basepackage 하위의 모든 패키지를 대상으로 읽어온다
		
		List<String> apiNameList = new ArrayList<String>();
		
		for(BeanDefinition clss : classSet) {
			apiNameList.add(clss.getBeanClassName());
		}
		
		return apiNameList;
	
	}
	
	

}

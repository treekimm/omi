package com.tree.omi.apidoc.service.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Service;

import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.filter.ControllerFilter;

@Service("ApidocService")
public class ApidocServiceImpl implements ApidocService {

	@Override
	public void printApiList() throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		
		Set<BeanDefinition> packageSet = new HashSet();
		
		packageSet = scanner.findCandidateComponents("/com/tree/omi");
		
		for(BeanDefinition clss : packageSet) {
			System.out.println(clss.getBeanClassName());
		}
		
	}

	@Override
	public List<String> getApiName() throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true); // useDefaultFilters : true -> stereotype Annotation �� ��ĵ �� ���ֵ��� ���ִ� param
		ControllerFilter exceptNotControllerFilter = new ControllerFilter(); // Ŀ���� ���� �ν��Ͻ� ���� -> ��Ʈ�ѷ� Ŭ������ �о���Բ� ���͸� TypeFilter�� ����ü
		scanner.addExcludeFilter(exceptNotControllerFilter); // custom filter ����
		
		Set<BeanDefinition> packageSet = new HashSet();
		
		packageSet = scanner.findCandidateComponents("/com/tree/omi"); // basepackage ������ ��� ��Ű���� ������� �о�´�
		
		List<String> apiNameList = new ArrayList<String>();
		String[] tempApiNameList ;
		String apiName = "";
		
		for(BeanDefinition clss : packageSet) {
//			tempApiNameList = clss.getBeanClassName().split("\\."); //
//			apiName = tempApiNameList[tempApiNameList.length-1];
//			apiNameList.add(apiName);
			apiNameList.add(clss.getBeanClassName());
		}
		
		return apiNameList;
	}

	@Override
	public HashMap<String,Object> getClassInfo(String className) throws Exception {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		System.out.println("==============================hiiiiiiiiiiiii");
		
		Class clzz = Class.forName(className);
		Method[] methodArray = clzz.getMethods();
		List methodList = new ArrayList<String>();
		for(Method m : methodArray) {
			methodList.add(m.getName());		// json ��ȯ�� ���� string Ÿ�� ����Ʈ�� �ٽ� ������ش�.
		}
		Field[] fieldArray = clzz.getFields();
		List fieldList = new ArrayList<String>();
		
		for(Field f : fieldArray) {
			fieldList.add(f.getName());
		}
		
		resultMap.put("method", methodList);
		resultMap.put("field", fieldList);

		System.out.println("==============================byeiiiiiiiiiiii");
		
		return resultMap;
	}

	@Override
	public HashMap<String, HashMap<String,Object>> getApiInfoList(List<String> paramList) throws Exception {
		HashMap<String, HashMap<String,Object>> resultMap = new HashMap<String, HashMap<String,Object>>();
		
		for(String apiName : paramList) {
			resultMap.put(apiName,getClassInfo(apiName));
		}
		
		return resultMap;
	}
	
	

}

package com.tree.omi.apidoc.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.stereotype.Service;

import com.tree.omi.apidoc.service.ApidocService;
import com.tree.omi.common.filter.ControllerFilter;
import com.tree.omi.common.filter.DtoFilter;

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
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true); // useDefaultFilters : true -> stereotype Annotation 만 스캔 할 수있도록 해주는 param
		ControllerFilter exceptNotControllerFilter = new ControllerFilter(); // 커스텀 필터 인스턴스 생성 -> 컨트롤러 클래스만 읽어오게끔 필터링 TypeFilter의 구현체
		scanner.addExcludeFilter(exceptNotControllerFilter); // custom filter 적용
		
		Set<BeanDefinition> packageSet = new HashSet();
		
		packageSet = scanner.findCandidateComponents("/com/tree/omi"); // basepackage 하위의 모든 패키지를 대상으로 읽어온다
		
		List<String> apiNameList = new ArrayList<String>();
		
		for(BeanDefinition clss : packageSet) {
			apiNameList.add(clss.getBeanClassName());
		}
		
		return apiNameList;
	}
	

	@Override
	public List<String> getDtoName() throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);// useDefaultFilters : false -> 스캔하는 조건이 아무것도 없는 상태
		DtoFilter includeNotDtoFilter = new DtoFilter();
		scanner.addIncludeFilter(includeNotDtoFilter);
		
		Set<BeanDefinition> classSet = new HashSet<BeanDefinition>();
		
		classSet = scanner.findCandidateComponents("/com/tree/omi");
		
		List<String> dtoNameList = new ArrayList<String>();
		
		for(BeanDefinition dto : classSet) {
			dtoNameList.add(dto.getBeanClassName());
		}
		
		return dtoNameList;
	}
	
	

	@Override
	public HashMap<String,Object> getClassInfo(String className) throws Exception {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		Class clzz = Class.forName(className);
		Method[] methodArray = clzz.getMethods();
		Field[] fieldArray = clzz.getDeclaredFields(); //getFiled는 private 으로 되어있는 필드는 가져오지 못한다. ..... getDeclaredFields로 변경
		
		List methodList = new ArrayList<String>();
		for(Method m : methodArray) {
			methodList.add(m.getName());		// json 변환을 위해 string 타입 리스트로 다시 만들어준다.
		}
		
		List fieldList = new ArrayList<String>();
		String[] fieldNameFullPath ;		
		for(Field f : fieldArray) {
			fieldNameFullPath = f.toString().split("\\.");
			fieldList.add(fieldNameFullPath[fieldNameFullPath.length-1].toString());
		}
		
		resultMap.put("method", methodList);
		resultMap.put("field", fieldList);

		return resultMap;
	}

	@Override
	public HashMap<String, HashMap<String,Object>> getApiInfoList(List<String> paramList) throws Exception {
		
		HashMap<String, HashMap<String,Object>> resultMap = new HashMap<String, HashMap<String,Object>>();
		HashMap<String,Object> classInfo = new HashMap<String,Object>();
		
		for(String clss : paramList) {
			classInfo = getClassInfo(clss);
			clss= clss.split("\\.")[clss.split("\\.").length-1].toString(); 
			
			resultMap.put(clss,classInfo);
		}
		
		return resultMap;
	}

	
	

}

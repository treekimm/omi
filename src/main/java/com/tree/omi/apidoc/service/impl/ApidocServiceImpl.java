package com.tree.omi.apidoc.service.impl;

import java.util.ArrayList;
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
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		ControllerFilter myFilter = new ControllerFilter();
		scanner.addExcludeFilter(myFilter);
		
		Set<BeanDefinition> packageSet = new HashSet();
		
		packageSet = scanner.findCandidateComponents("/com/tree/omi");
		
		List<String> apiNameList = new ArrayList<String>();
		String[] tempApiNameList ;
		String apiName = "";
		
		for(BeanDefinition clss : packageSet) {
			tempApiNameList = clss.getBeanClassName().split("\\.");
			apiName = tempApiNameList[tempApiNameList.length-1];
			apiNameList.add(apiName);
		}
		
		return apiNameList;
	}

}

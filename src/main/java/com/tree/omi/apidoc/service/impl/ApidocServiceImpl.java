package com.tree.omi.apidoc.service.impl;

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
	public List<String> getApinName(HttpServletRequest request) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		RealApidocFilter filter = new RealApidocFilter("ANNOTATION","CONTROLLER");
		
		scanner.addExcludeFilter(filter);
		
		Set<BeanDefinition> packageSet = new HashSet();
		
		packageSet = scanner.findCandidateComponents("/com/tree/omi"); // basepackage 하위의 모든 패키지를 대상으로 읽어온다
		
		List<String> apiNameList = new ArrayList<String>();
		
		for(BeanDefinition clss : packageSet) {
			apiNameList.add(clss.getBeanClassName());
		}
		
		return apiNameList;
	}

}

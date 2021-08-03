package com.tree.omi.common.filter;

import java.io.IOException;
import java.util.Set;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

public class RealApidocFilter extends ApidocFilter{
	
	private String filterType = "";
	private String targetAnnotation = "";
	
	public RealApidocFilter(String filterType) {
		this.filterType = filterType;
	};
	
	public RealApidocFilter(String filterType, String targetAnnotation) {
		this.filterType = filterType;
		this.targetAnnotation = targetAnnotation;
	};
	
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		
		if(filterType.equals("ANNOTATION")) {
			AnnotationMetadata metaData = metadataReader.getAnnotationMetadata();
			Set<String> annotationSet = metaData.getAnnotationTypes();
			
			if(targetAnnotation.equals("CONTROLLER")) {
				targetAnnotation = "org.springframework.stereotype.Controller";
			} else if(targetAnnotation.equals("APIDOCANNOTATION")) {
				targetAnnotation = "com.tree.omi.common.annotation.ApidocAnnotation";
			}
			
			if(!annotationSet.contains(targetAnnotation)) {
				return true;
			}
			
		} else if (filterType.equals("CLASS")) {	// 내부에서만 사용되는 패키지는 제외한다
			ClassMetadata metaData = metadataReader.getClassMetadata();
			String className = metaData.getClassName();
			
			if((className.contains("com.tree.omi.common") || className.contains("com.tree.omi.test") || className.contains("com.tree.omi.apidoc") || className.contains("com.tree.omi.view"))) {
				return true;
			}
			
		} else if (filterType.equals("RESOURCE")) {
			
		}
		
		return false;
	}

}

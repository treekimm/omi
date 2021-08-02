package com.tree.omi.common.filter;

import java.io.IOException;
import java.util.Set;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class TestControllerFilter implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		
		AnnotationMetadata anootationMetadata = metadataReader.getAnnotationMetadata() ; 
		Set<String> annotationSet = anootationMetadata.getAnnotationTypes();
		
		if(!annotationSet.contains("org.springframework.stereotype.Controller")) {
			return true;
		}
		
		return false;
	}

}

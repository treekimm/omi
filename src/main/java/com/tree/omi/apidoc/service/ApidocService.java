package com.tree.omi.apidoc.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tree.omi.apidoc.dto.ControllerListResponseDTO;
import com.tree.omi.apidoc.dto.ControllerListSubResponseDTO;

public interface ApidocService {
	public List<Method> getApiList(String className)throws Exception;
	public List<ControllerListSubResponseDTO> getControllerList(HttpServletRequest request)throws Exception;
	public List<Class> getApiParamList(Method method) throws Exception;
	public List<HashMap<String,String>> getDtoField(Class dto) throws Exception;
}

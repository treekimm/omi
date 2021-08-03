package com.tree.omi.apidoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ApidocService {
	public List<String> getApiList(HttpServletRequest request)throws Exception;
	public List<String> getControllerList(HttpServletRequest request)throws Exception;
}

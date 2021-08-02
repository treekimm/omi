package com.tree.omi.apidoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ApidocService {
	public List<String> getApinName(HttpServletRequest request)throws Exception;
}

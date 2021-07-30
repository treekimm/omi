package com.tree.omi.apidoc.service;

import java.util.HashMap;
import java.util.List;

public interface ApidocService {
	public void printApiList() throws Exception;
	public List<String> getApiName() throws Exception;
	public List<String> getDtoName() throws Exception;
	public HashMap<String,Object> getClassInfo(String className) throws Exception ;
	public HashMap<String,HashMap<String,Object>> getApiInfoList(List<String> paramList) throws Exception;
}

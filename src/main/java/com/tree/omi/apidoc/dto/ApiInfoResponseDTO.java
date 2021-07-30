package com.tree.omi.apidoc.dto;

import java.util.HashMap;
import java.util.List;

import com.tree.omi.common.base.BaseDTO;

public class ApiInfoResponseDTO extends BaseDTO{
	private HashMap<String,HashMap<String,Object>> resultMap ;
	private List<String> apiNameList;
	private List<String> dtoNameList;

	public List<String> getDtoNameList() {
		return dtoNameList;
	}

	public void setDtoNameList(List<String> dtoNameList) {
		this.dtoNameList = dtoNameList;
	}

	public HashMap<String, HashMap<String, Object>> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, HashMap<String, Object>> resultMap) {
		this.resultMap = resultMap;
	}

	public List<String> getApiNameList() {
		return apiNameList;
	}

	public void setApiNameList(List<String> apiNameList) {
		this.apiNameList = apiNameList;
	}
}

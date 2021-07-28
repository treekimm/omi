package com.tree.omi.apidoc.dto;

import java.util.HashMap;

import com.tree.omi.common.base.BaseDTO;

public class ApiInfoResponseDTO extends BaseDTO{
	private HashMap<String,HashMap<String,Object>> result ;

	public HashMap<String, HashMap<String, Object>> getResult() {
		return result;
	}

	public void setResult(HashMap<String, HashMap<String, Object>> result) {
		this.result = result;
	}
}

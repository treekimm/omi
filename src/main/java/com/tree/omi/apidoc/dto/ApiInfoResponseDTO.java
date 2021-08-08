package com.tree.omi.apidoc.dto;

import java.util.HashMap;
import java.util.List;

import com.tree.omi.common.base.BaseDTO;

public class ApiInfoResponseDTO extends BaseDTO{

	private List<HashMap<String,HashMap<String,List<HashMap<String,String>>>>> result;

	public List<HashMap<String, HashMap<String, List<HashMap<String, String>>>>> getResult() {
		return result;
	}

	public void setResult(List<HashMap<String, HashMap<String, List<HashMap<String, String>>>>> result) {
		this.result = result;
	}
}

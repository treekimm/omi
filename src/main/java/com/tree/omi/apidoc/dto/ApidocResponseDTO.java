package com.tree.omi.apidoc.dto;

import java.util.List;

import com.tree.omi.common.base.BaseDTO;

public class ApidocResponseDTO extends BaseDTO{

	private List<String> apiList ;

	public List<String> getApiList() {
		return apiList;
	}

	public void setApiList(List<String> apiList) {
		this.apiList = apiList;
	}
}

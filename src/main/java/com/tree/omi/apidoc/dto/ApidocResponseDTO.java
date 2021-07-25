package com.tree.omi.apidoc.dto;

import java.util.ArrayList;

import com.tree.omi.common.base.BaseDTO;

public class ApidocResponseDTO extends BaseDTO{

	private ArrayList<String> apiList ;

	public ArrayList<String> getApiList() {
		return apiList;
	}

	public void setApiList(ArrayList<String> apiList) {
		this.apiList = apiList;
	}
}

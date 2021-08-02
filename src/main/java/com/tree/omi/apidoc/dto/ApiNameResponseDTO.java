package com.tree.omi.apidoc.dto;

import java.util.List;

import com.tree.omi.common.base.BaseDTO;

public class ApiNameResponseDTO extends BaseDTO{
	private List<String> name ;

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	
}

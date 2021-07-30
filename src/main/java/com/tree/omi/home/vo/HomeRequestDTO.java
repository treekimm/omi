package com.tree.omi.home.vo;

import com.tree.omi.common.annotation.DtoAnnotation;
import com.tree.omi.common.base.BaseDTO;

@DtoAnnotation
public class HomeRequestDTO extends BaseDTO {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
}

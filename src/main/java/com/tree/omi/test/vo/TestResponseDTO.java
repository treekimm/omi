package com.tree.omi.test.vo;

import com.tree.omi.common.base.BaseDTO;

public class TestResponseDTO extends BaseDTO{
	private String text = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

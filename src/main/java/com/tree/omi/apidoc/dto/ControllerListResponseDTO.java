package com.tree.omi.apidoc.dto;

import java.util.List;

import com.tree.omi.common.base.BaseDTO;

public class ControllerListResponseDTO extends BaseDTO{
	private List<ControllerListSubResponseDTO> result ;

	public List<ControllerListSubResponseDTO> getResult() {
		return result;
	}

	public void setResult(List<ControllerListSubResponseDTO> result) {
		this.result = result;
	}
}

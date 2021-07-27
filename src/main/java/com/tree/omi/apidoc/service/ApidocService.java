package com.tree.omi.apidoc.service;

import java.util.List;

public interface ApidocService {
	public void printApiList() throws Exception;
	public List<String> getApiName() throws Exception;
}

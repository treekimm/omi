package com.tree.omi.apidoc.service;

import java.util.ArrayList;

public interface ApidocService {
	void printApiList() throws Exception;
	ArrayList<String> getApiName() throws Exception;
}

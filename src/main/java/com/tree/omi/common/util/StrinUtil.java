package com.tree.omi.common.util;

public class StrinUtil {
	public String getShortName(String fullPackageName) throws Exception {
		String result = "";
		String[] temp = fullPackageName.split("\\.");
		result = temp[temp.length-1];
		return result;
	}
}

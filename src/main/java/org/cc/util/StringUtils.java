package org.cc.util;

public class StringUtils {
	
	public static  boolean isNotEmpty(String str) {
		if(str == null && str.equals("")) {
			return false;
		}
		return true;
	}
}

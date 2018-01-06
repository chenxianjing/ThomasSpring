package org.cc.entry;

import java.util.List;

import lombok.Data;
@Data
public class Beans {
	
	/**
	 * 对象名
	 */
	private String id;
	
	/**
	 * 类名
	 */
	private String type;
	
	private List<PropertyDefine> propertyList;
}

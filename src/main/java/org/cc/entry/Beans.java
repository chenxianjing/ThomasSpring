package org.cc.entry;

import java.util.HashMap;
import java.util.Map;

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
	
	private Map<String,Object> properties = new HashMap<>();
	
	public Beans(String id,String type) {
		this.id = id;
		this.type = type;
	}
	
}

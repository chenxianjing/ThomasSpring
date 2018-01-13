package org.cc.entry;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.cc.util.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApplicationContext {
	
	private List<Beans> beanList = new ArrayList<>();
	//用来存储实例化后的bean
	private Map<String, Object> sigletons =new HashMap<>();
	
	public ApplicationContext(String fileName) {
		this.readXml(fileName);
		this.instanceBeans();
		this.injection();
	}
	
	/**
	 * 
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		return sigletons.get(beanName);
	}
	/**
	 * 根据文件名读取xml的配置文件
	 * @param fileName
	 */
	private void readXml(String fileName) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
			document = saxReader.read(xmlPath);
			Element rootElement = document.getRootElement();
			Iterator<Element> it = rootElement.elementIterator();
			Element element = null;
			Beans beans = null;
			Iterator<Element> sonIterator = null;
			Element sonElement = null;
			PropertyDefine propertyDefine = null;
			List<PropertyDefine> list = null;
			while(it.hasNext()) {
				beans = new Beans();
				element = it.next();
				beans.setId(element.attributeValue("id"));
				beans.setType(element.attributeValue("class"));
				sonIterator = element.elementIterator();
				list  = new ArrayList<>();
				while(sonIterator.hasNext()) {
					sonElement = sonIterator.next();
					propertyDefine = new PropertyDefine();
					propertyDefine.setName(sonElement.attributeValue("name"));
					propertyDefine.setValue(sonElement.attributeValue("value"));
					propertyDefine.setRef(sonElement.attributeValue("ref"));
					list.add(propertyDefine);
				}
				beans.setPropertyList(list);
				beanList.add(beans);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void instanceBeans() {
		if(!beanList.isEmpty()) {
			String className = null;
			for(Beans beans : beanList) {
				className = beans.getType();
				if(StringUtils.isNotEmpty(className)) {
					try {
						sigletons.put(beans.getId(), Class.forName(className).newInstance());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						Logger.getGlobal().info("bean实例化失败");
						e.printStackTrace();
					}
				}
			}
		}else {
			Logger.getGlobal().info("xml并没有配置bean");
		}
	}
	
	private void injection() {
		if(!beanList.isEmpty()) {
			String className = null;
			List<PropertyDefine> list = null;
			Class<?> cl = null;
			Field field = null;
			String pName = "";
			String pValue = "";
			String pRef = "";
			try {
				for(Beans beans : beanList) {
					className = beans.getType();
					list = beans.getPropertyList();
					Object object = sigletons.get(beans.getId());
					cl = Class.forName(className);
					for(PropertyDefine propertyDefine:list) {
						pName = propertyDefine.getName();
						pValue = propertyDefine.getValue();
						pRef = propertyDefine.getRef();
						field = cl.getDeclaredField(pName);
						field.setAccessible(true);
						if(pRef != null) {
							field.set(object, sigletons.get(propertyDefine.getRef()));
						}else if(pValue != null) {
							field.set(object, pValue);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

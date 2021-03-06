package org.cc.test;

import org.cc.entry.ApplicationContext;
import org.cc.service.Animal;

public class TestApplicationContext {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ApplicationContext("beans.xml");
		Animal animal = (Animal) applicationContext.getBean("animal");
		animal.voice();
	}
	
	public static <T extends Comparable<T>> T min(T[] a) {
		return a[a.length-1];
	}
}

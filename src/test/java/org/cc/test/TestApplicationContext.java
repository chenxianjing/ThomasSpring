package org.cc.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TestApplicationContext {
	
	public static void main(String[] args) {
		/*ApplicationContext applicationContext = new ApplicationContext("beans.xml");
		Animal animal = (Animal) applicationContext.getBean("animal");
		animal.voice();*/
		GregorianCalendar[] gregorianCalendar = new GregorianCalendar[2];
		gregorianCalendar[0] = new GregorianCalendar();
		gregorianCalendar[1] = new GregorianCalendar();
		min(gregorianCalendar);
		ArrayList<?> list = new ArrayList<>();
		list.add(null);
	}
	
	public static <T extends Comparable<T>> T min(T[] a) {
		return a[a.length-1];
	}
}

package org.cc.service.impl;

import java.util.logging.Logger;

import org.cc.dao.PersonDao;
import org.cc.service.Animal;

public class Cat implements Animal {
	
	private PersonDao personDao;
	
	private String age;
	
	@Override
	public void voice() {
		// TODO Auto-generated method stub
		personDao.eatFood();
		Logger.getGlobal().info("猫叫");
	}

}

package org.cc.dao.impl;

import java.util.logging.Logger;

import org.cc.dao.PersonDao;

public class PersonDaoImpl implements PersonDao{

	@Override
	public void eatFood() {
		// TODO Auto-generated method stub
		Logger.getGlobal().info("人在吃饭");
	}

}

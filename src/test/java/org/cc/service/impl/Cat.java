package org.cc.service.impl;

import java.util.logging.Logger;

import org.cc.service.Animal;

public class Cat implements Animal {

	@Override
	public void voice() {
		// TODO Auto-generated method stub
		Logger.getGlobal().info("猫叫");
	}

}

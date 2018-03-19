package org.cc.entry;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TransactionHandler implements MethodInterceptor, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831167368221908491L;

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		arg3.invokeSuper(arg0, arg2);
		return null;
	}

}

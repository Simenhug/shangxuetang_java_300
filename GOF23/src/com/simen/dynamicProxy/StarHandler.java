package com.simen.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{
	Star realStar;
	
	public StarHandler(Star realStar) {
		// TODO Auto-generated constructor stub
		this.realStar = realStar;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object obj = null;
		if (method.getName().equals("sing")) {
			obj = method.invoke(realStar, args);
		}
		return obj;
	}

}

package com.simen.sorm.core;

public class QueryFactory {
	
	private static QueryFactory factory= null;
	private static Query protoQuery= null; //原型对象
	
	private QueryFactory() { //私有化构造器
	}
	static {
		factory = new QueryFactory();
		Class c;
		try {
			c = Class.forName(DBManager.getConfig().getQueryClass());
			protoQuery = (Query) c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Query createQuery() {
		try {
			return (Query) protoQuery.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	};
}

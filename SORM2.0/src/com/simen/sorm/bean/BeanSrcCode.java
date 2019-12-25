package com.simen.sorm.bean;
/**
 * 封账了Javabean属性和get set方法的源代码
 * @author xinmianhuang
 *
 */
public class BeanSrcCode {
	/**
	 * bean的所有属性 如 private int id;
	 */
	private String beanFields;
	/**
	 * 所有的get方法源码
	 */
	private String getters;
	/**
	 * 所有的set方法源码
	 */
	private String setters;
	
	public String getBeanFields() {
		return beanFields;
	}
	public void setBeanFields(String beanFields) {
		this.beanFields = beanFields;
	}
	public String getGetters() {
		return getters;
	}
	public void setGetters(String getters) {
		this.getters = getters;
	}
	public String getSetters() {
		return setters;
	}
	public void setSetters(String setters) {
		this.setters = setters;
	}
	@Override
	public String toString() {
		System.out.println(beanFields);
		System.out.println(getters);
		System.out.println(setters);
		return super.toString();
	}
	
	public BeanSrcCode(String beanFields, String getters, String setters) {
		super();
		this.beanFields = beanFields;
		this.getters = getters;
		this.setters = setters;
	}
	public BeanSrcCode() {};
}

package com.simen.vo;
/**
 * VO: value object
 * 用来存储复杂的查询结果
 * @author xinmianhuang
 *
 */
public class EmpVo {
	//select e.empname, e.age, e.salary+e.bonus 'income', d.address 'deptAddr' from emp e
	//join dept d on e.deptid=d.id;
	
	private String empname;
	private Integer age;
	private Double income;
	private String deptAddr;
	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getDeptAddr() {
		return deptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	public EmpVo(String empname, Integer age, Double income, String deptAddr) {
		super();
		this.empname = empname;
		this.age = age;
		this.income = income;
		this.deptAddr = deptAddr;
	}
	
	public EmpVo() {
		
	}
}

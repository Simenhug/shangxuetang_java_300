package com.simen.sormdemo.test;

import java.util.List;

import com.simen.sorm.core.Query;
import com.simen.sorm.core.QueryFactory;
import com.simen.test.po.Emp;
import com.simen.test.vo.EmpVO;

public class Test {

	public static void main(String[] args) {
//		TableContext.createAllJavaFiles();
		
		selectbyid();
	}
	
	public static void add() {
		Emp e = new Emp();
		e.setAge(18);
		e.setEmpname("gabe");
		e.setSalary(6000.0);
		
		Query q = QueryFactory.createQuery();
		q.insert(e);
	}
	
	public static void select() {
		Query q = QueryFactory.createQuery();
		Number n = q.queryNumber("select count(*) from emp where salary>?", new Object[] {100});
		System.out.println(n);
	}
	
	public static void delete() {
		Emp e = new Emp();
		e.setAge(18);
		e.setEmpname("gabe");
		e.setId(14);
		Query q = QueryFactory.createQuery();
		q.delete(e);
	}
	
	public static void update() {
		Emp e = new Emp();
		e.setAge(18);
		e.setEmpname("della");
		e.setId(11);
		e.setSalary(100000.0);
		Query q = QueryFactory.createQuery();
		q.update(e, new String[] {"salary"});
	}
	
	public static void selectrow() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp)q.querySingleRow("select * from emp where id=?", Emp.class, new Object[] {11});
		System.out.println(e.getEmpname());
	}
	
	public static void selectmultirow() {
		Query q = QueryFactory.createQuery();
		List<Emp> e = (List)q.queryRows("select * from emp where id<?", Emp.class, new Object[] {110});
		for (Emp person : e) {
			System.out.println(person.getEmpname());
		}
	}
	
	public static void selectjointtable() {
		Query q = QueryFactory.createQuery();
		String sql = "select e.id,e.empname,e.age,d.dname 'deptName',d.address 'deptAddr' from emp e join dept d on e.deptId=d.id";
		List<EmpVO> e = (List)q.queryRows(sql, EmpVO.class, new Object[] {});
		for (EmpVO person : e) {
			System.out.println(person.getEmpname()+person.getDeptAddr());
		}
	}
	
	public static void selectbyid() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp)q.queryById(Emp.class, 11);
		System.out.println(e.getEmpname());
	}
}
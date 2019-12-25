package com.simen.sorm.testing;

import java.util.List;

import com.simen.sorm.core.MySqlQuery;
import com.simen.vo.EmpVo;

public class ConnectionPoolSpeedTest {
	public static void noPoolTest() {
		String sql = "select e.empname, e.age, e.salary+e.bonus 'income', d.address 'deptAddr' from emp e\n" + 
				"join dept d on e.deptid=d.id";
		List<EmpVo> results = new MySqlQuery().queryRows(sql, EmpVo.class, null);
		for(EmpVo data: results) {
			System.out.println(data.getEmpname()+" "+data.getDeptAddr());
		}
	}
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i=0;i<3000;i++) {
			noPoolTest();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time: "+(endTime-startTime)); //不加连接池的耗时8224，增加连接池后1758
	}
}

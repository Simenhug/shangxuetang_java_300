package com.simen.reflection.genericAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
	public static void main(String[] args) {
		try {
			Class clas = Class.forName("com.simen.reflection.genericAnnotation.MyStudent");
			//获得该类的所有注解
			Annotation[] annos = clas.getAnnotations();
			for(Annotation anno: annos) {
				System.out.println(anno);
			}
			//根据类名获得某指定注解类
			StudentTable stable = (StudentTable) clas.getAnnotation(StudentTable.class);
			System.out.println(stable.value());
			//获得类的属性的注解
			Field f = clas.getDeclaredField("studentName");
			StudentField sfield = f.getAnnotation(StudentField.class);
			System.out.println(sfield.columnName()+"--"+sfield.type()+"--"+sfield.length());
			//根据获得的表名、字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL，在数据库中生成相关的表
			Method m = clas.getDeclaredMethod("setStudentName", String.class);
			StudentMethod smethod = m.getAnnotation(StudentMethod.class);
			System.out.println(smethod.value());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

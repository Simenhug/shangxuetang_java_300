package com.simen.javassistdemo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMember;
import javassist.CtMethod;

/*
 * 使用Javassist建立新的类
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.simen.javassistTest.subject");
		
		//创建属性
		CtField f1 = CtField.make("private int num;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//创建方法
		CtMethod m1 = CtMethod.make("public void setNum(int num){this.num = num;}", cc);
		CtMethod m2 = CtMethod.make("public void setName(String name){this.name = name;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//添加构造器
		CtConstructor ructor = new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		ructor.setBody("{this.num = $1; this.name = $2;}");
		cc.addConstructor(ructor);
		//将构造好的类写入某文件
		cc.writeFile("src/files");
	}
}

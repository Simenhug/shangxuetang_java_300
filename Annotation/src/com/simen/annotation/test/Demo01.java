package com.simen.annotation.test;

@MyAnnotation
public class Demo01 {
	
	@MyAnnotation(age=19, studentName="della", id=001, schools= {"Columbia"})
	public void test() {

	}
	
	@Value("della")
	public void test2() {
		
	}

}

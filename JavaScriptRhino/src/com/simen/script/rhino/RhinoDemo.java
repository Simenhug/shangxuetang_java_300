package com.simen.script.rhino;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class RhinoDemo {
	public static void main(String[] args) throws Exception {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript"); //或者getEngineByName("js");
		
		//定义变量，存储到引擎上下文中
		engine.put("simen", "loves della");
		String str = "var user = {name:'simen', age:18, schools:['Stanford','Boston University']};";
		str += "println(user.name);";
		// str += "print(user.name);"; 也可以
		//执行脚本
		//由于版本问题，Nashorn代替了Rhino。println不被Nashorn支持。目前版本中print可代替println
		engine.eval("if(typeof println == 'undefined')this.println = print;");
		engine.eval(str);
		engine.eval("simen = 'really loves della';");
		System.out.println(engine.get("simen"));
		//定义函数
		engine.eval("function add(a,b){var sum = a+b; return sum;}");
		//执行js函数
		//取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		//执行脚本中定义的方法
		Object result = jsInvoke.invokeFunction("add", new Object[] {89,99});
		System.out.println(result);
		
		//解决Nashorn和Rhino的兼容问题
		engine.eval("load('nashorn:mozilla_compat.js')");
		//导入其他java包，使用其他包中的Java类
		String jsCode = "importPackage(java.util); var list=Arrays.asList([\"simen\",\"della\",\"abby\"]);";
		engine.eval(jsCode);
		List<String> list = (List<String>)engine.get("list");
		for(String name: list) {
			System.out.println(name);
		}
		
		//执行一个js文件
		URL url = RhinoDemo.class.getClassLoader().getResource("com/simen/script/rhino/TestSum.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
}

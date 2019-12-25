package com.simen.sorm.utils;
/**
 * 封装了生成Java文件（源代码）常用的操作
 * @author xinmianhuang
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.simen.sorm.bean.BeanSrcCode;
import com.simen.sorm.bean.ColumnInfo;
import com.simen.sorm.bean.TableInfo;
import com.simen.sorm.core.DBManager;
import com.simen.sorm.core.MySqlTypeConvertor;
import com.simen.sorm.core.TableContext;
import com.simen.sorm.core.TypeConvertor;

public class JavaFileUtils {
	/**
	 * 根据字段信息生成Javabean属性信息。如：varchar username==>private Stringusername;以及相应的get set方法源码
	 * @param column sql字段信息
	 * @param convertor 类型转化器
	 * @return Javabean中关于该sql字段的源码
	 */
	public static BeanSrcCode makeBeanCode(ColumnInfo column, TypeConvertor convertor) {
		BeanSrcCode bean = new BeanSrcCode();
		String beanFieldType = convertor.databaseType2Java(column.getDataType());
		String columnName = column.getName();
		
		//generate source code for fields
		StringBuilder fieldBuilder = new StringBuilder();
		fieldBuilder.append("\tprivate ").append(beanFieldType).append(" ").append(columnName).append(";\n");
		bean.setBeanFields(fieldBuilder.toString());
		
		//generate source code for getter
		//public Type getField(){return field;}
		StringBuilder getterBuilder = new StringBuilder();
		getterBuilder.append("\tpublic "+beanFieldType+" ");
		getterBuilder.append("get"+StringUtils.capFirstLetter(columnName));
		getterBuilder.append("(){ \n");
		getterBuilder.append("\treturn "+columnName+";\n");
		getterBuilder.append("\t}\n");
		bean.setGetters(getterBuilder.toString());
		
		//generate source code for setter
		//public void setField(Type field){this.field = field;}
		StringBuilder setterBuilder = new StringBuilder();
		setterBuilder.append("\tpublic void ");
		setterBuilder.append("set"+StringUtils.capFirstLetter(columnName));
		setterBuilder.append("("+beanFieldType+" "+columnName+"){\n");
		setterBuilder.append("\tthis."+columnName+" = "+columnName+";\n");
		setterBuilder.append("\t}\n");
		bean.setSetters(setterBuilder.toString());
		
		return bean;
	}
	
	/**
	 * 根据表信息生成Java类源代码
	 * @param tableInfo 表信息
	 * @param convertor 类型转换器
	 * @return Java类源代码
	 */
	public static String makeFileCode(TableInfo tableInfo, TypeConvertor convertor) {

		StringBuilder srcCode = new StringBuilder();
		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<BeanSrcCode> beans = new ArrayList<BeanSrcCode>();
		for(ColumnInfo c: columns.values()) {
			beans.add(makeBeanCode(c, convertor));
		}
		
		//生成package语句
		srcCode.append("package "+DBManager.getConfig().getPoPackage()+";\n\n");
		
		//生成import语句
		srcCode.append("import java.sql.*;\n");
		srcCode.append("import java.util.*;\n\n");
		
		//生成类声明
		srcCode.append("public class "+StringUtils.capFirstLetter(tableInfo.getTname())+"{\n\n");
		
		//生成属性
		for(BeanSrcCode bean: beans) {
			srcCode.append(bean.getBeanFields());
		}
		srcCode.append("\n\n");
		//生成getters
		for(BeanSrcCode bean: beans) {
			srcCode.append(bean.getGetters());
		}
		//生成setters
		for(BeanSrcCode bean: beans) {
			srcCode.append(bean.getSetters());
		}
		//添加结尾大括号
		srcCode.append("}\n");
		
		return srcCode.toString();
	}
	
	/**
	 * 根据表信息生成Java类文件并存入指定包中
	 * @param tableInfo 表信息
	 * @param convertor 类型转化器
	 */
	public static void makeFile(TableInfo tableInfo, TypeConvertor convertor) {
		String path = DBManager.getConfig().getSrcPath();
		path += "/" + DBManager.getConfig().getPoPackage().replaceAll("\\.", "/");
		File dest = new File(path);
		if(!dest.exists()) {
			dest.mkdir();
		}
		path += "/"+StringUtils.capFirstLetter(tableInfo.getTname())+".java";
		BufferedWriter bwriter = null;
		String srcCode = makeFileCode(tableInfo, convertor);
		
		try {
			bwriter = new BufferedWriter(new FileWriter(path));
			bwriter.write(srcCode);
//			System.out.println("created "+path);
			bwriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bwriter != null) {
					bwriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {		
		Map<String,TableInfo> map = TableContext.tables;
		TypeConvertor convertor = new MySqlTypeConvertor();
		for(TableInfo info: map.values()) {
			makeFile(info, convertor);
		}
	}
}
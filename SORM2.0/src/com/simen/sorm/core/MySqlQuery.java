package com.simen.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simen.sorm.bean.ColumnInfo;
import com.simen.sorm.bean.TableInfo;
import com.simen.sorm.utils.JDBCUtils;
import com.simen.sorm.utils.ReflectUtils;
import com.simen.sorm.utils.StringUtils;

public class MySqlQuery extends Query{
	
	@Override
	public Object queryPagination(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}

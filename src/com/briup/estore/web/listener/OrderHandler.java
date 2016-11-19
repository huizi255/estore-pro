package com.briup.estore.web.listener;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.estore.bean.Order;

public class OrderHandler extends BaseTypeHandler<Order>{

	@Override
	public Order getNullableResult(ResultSet arg0, String arg1) throws SQLException {
		return null;
	}

	@Override
	public Order getNullableResult(ResultSet arg0, int arg1) throws SQLException {
		return null;
	}

	@Override
	public Order getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1, Order arg2, JdbcType arg3) throws SQLException {
		
	}

}

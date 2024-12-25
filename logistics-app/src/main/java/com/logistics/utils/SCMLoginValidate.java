package com.logistics.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCMLoginValidate {

	public static String validation(String username, String password, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {

		Connection connection = null;
		CallableStatement callableStatement = null;
		DBProxy dbProxy = new DBProxy();
		ResultSet resultSet = null;

		try {
			connection = dbProxy.openDBconnection();
			dbProxy = null;
		} catch (Exception e) {
			return null;
		}

		try {
			String query = "{? = call pglobal.uservalid(?,?)}";
			callableStatement = connection.prepareCall(query);
			callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			callableStatement.setString(2, username);
			callableStatement.setString(3, password);

			callableStatement.execute();
			query = null;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		return callableStatement.getString(1);

	}

}

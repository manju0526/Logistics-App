package com.logistics.utils;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBProxy {

	Connection dbConn;
	InitialContext ic;

	public DBProxy() {
		dbConn = null;
		ic = null;
	}

	public Connection openDBconnection() {
		try {
			try {
				ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("/jdbc/OracleDS");
				dbConn = ds.getConnection();
				Connection connection = dbConn;
				return connection;
			} catch (Exception e) {
				System.out.println("Error occured in the database connection: ");
			}
			Connection connection1 = null;
			return connection1;
		} finally {
			ic = null;
		}
	}

}

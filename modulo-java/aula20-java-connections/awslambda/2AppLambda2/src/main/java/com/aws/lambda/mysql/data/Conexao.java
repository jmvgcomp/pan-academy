package com.aws.lambda.mysql.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		  public static void main(String[] args) throws SQLException, ClassNotFoundException {
		        // TODO Auto-generated method stub

		        Connection con = null;
			    String hostName = "#";
		        
		        String userName = "admin";
		        String password = "12345678";
		        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		        String dataBaseName = "dblambda";
		        String dataBasePrefix = "jdbc:mysql://";
			  	String dabaBasePort = "3306";

			  String url = dataBasePrefix + hostName + ":"+dabaBasePort+"/" + dataBaseName ;

		        Class.forName(jdbcDriver);
		        con = DriverManager.
		                getConnection(url, userName, password);

		        con.close();

		    }

}
	 
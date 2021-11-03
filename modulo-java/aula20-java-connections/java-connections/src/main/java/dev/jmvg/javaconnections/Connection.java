package dev.jmvg.javaconnections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    String hostName = "database-1.cjrriz7oygwx.us-west-2.rds.amazonaws.com";
    String userName = "admin";
    String userPassword = "12345678";
    String driver = "com.mysql.cj.jdbc.Driver";
    String dataBase = "dblambda";
    String prefix = "jdbc:mysql://";
    String port = "3306";

    String url = prefix + hostName +  ":" + port + "/" + dataBase + "/";
    Class.forName("com.mysql.cj.jdbc");
    Connection con;

    {
        try {
            con = (Connection) DriverManager.getConnection(url, userName, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

package com.example.demomcvc11.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCMS {

    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/demoC1122H1";

    public static Connection getConnection(){
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(
                    URL,
                    "root",
                    "123456@Abc");
//            System.out.println("ket noi thanh cong");
            return connection;
        } catch (SQLException e) {
//            System.out.println("loi");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

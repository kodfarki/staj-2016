package com.servlet.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtil {
    private static JDBCUtil me = new JDBCUtil();
    private static Connection connection;

    Properties props = new Properties();
    InputStream input = null;

    static String driverClassName;
    static String url;
    static String userName;
    static String password;

    private JDBCUtil() {

        try {
            input = new FileInputStream("/Users/hamitsarac/projects/staj-2016/04.servlet.programming/servlet-project/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            props.load(input);

            driverClassName = props.getProperty("driverClassName");
            url = props.getProperty("url");
            userName = props.getProperty("userName");
            password = props.getProperty("password");

            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Driver Not Found");
        }
    }

    public static Connection getConnection() throws IOException {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

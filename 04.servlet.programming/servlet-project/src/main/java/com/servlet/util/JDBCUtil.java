package com.servlet.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by GUNEY on 2.08.2016.
 */
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
            input = new FileInputStream("config.properties");
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
                System.out.println("Connection Failed");
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

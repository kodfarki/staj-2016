package com.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by GUNEY on 2.08.2016.
 */
public class JDBCUtil {

    private static JDBCUtil me = new JDBCUtil();

    private static Connection connection;

    private JDBCUtil() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Driver Not Found");
        }

    }

    public static Connection getConnection() {
        if (connection == null) {

            try {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mzgg", "1");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection Failed");
            }
        }


        return connection;
    }
}

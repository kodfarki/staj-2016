package com.mustafasarac.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by mustafasarac on 3.08.2016.
 */

public class DatabaseConnection {
    // JDBC driver name and database URL
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    //  Database credentials
    private static final String USER = "mustafa";
    private static final String PASSWORD = "sento";

    //  Database Connection
    private static Connection connection;

    // Singleton Pattern
    private static DatabaseConnection databaseConnection = new DatabaseConnection();

    private DatabaseConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            Properties properties = new Properties();

        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            System.out.println("\nConnected database successfully...");
        } catch(SQLException exception){
            exception.printStackTrace();
            System.out.println("\nFailed database connection...");
            throw new RuntimeException(exception);
        }
        return connection;
    }

    // in order to close the connection after all operations
    public static void closeConnection(){
        try {
            connection.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}

package com.mustafasarac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mustafasarac on 1.08.2016.
 */

public class DatabaseConnection {

    // Singleton Pattern
    private static DatabaseConnection databaseConnection = new DatabaseConnection();

    //  Database Connection
    public static Connection connection;

    // JDBC driver name and database URL
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    //  Database credentials
    private static final String USER = "mustafa";
    private static final String PASSWORD = "sento";

    private DatabaseConnection(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch(SQLException exception){
            exception.printStackTrace();
            System.out.println("\nFailed database connection...");
        }
        return connection;
    }

    // in order to close the connection after all operations
    public static void closeConnection(){
        try {
            connection.close();
        } catch(SQLException exception){
            exception.printStackTrace();
            System.out.println("\nFailed on closing the connection...");
        }
    }
}

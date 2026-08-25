package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=MiniApiDB;encrypt=true;trustServerCertificate=true","miniapi_user","Vr0nWk#26_Xt!");
    }
}

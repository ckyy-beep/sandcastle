package com.example.sandcastle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "useraccounts";
        String databaseUser = "root";
        String databasePassword = "NC7^Oj70e@n3";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             //"org.apache.derby.jdbc.ClientDriver"
             databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return databaseLink;
    }
}


package com.shelly0.dmxduo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vogeslu on 03.10.17.
 */
public class MySQL {

    public Connection connection;

    public MySQL() {
        System.out.println("[Info] Trying to connect to database");

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            System.out.println("[Info] Created a SQL-Connection");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("[Error] Failed while creating a SQL-Connection: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            System.err.println("[Error] Failed while executing SQL-Query: "+e.getMessage());
        }
    }

    public void initialize() {
        executeQuery("CREATE TABLE IF NOT EXISTS barcodes (barcode INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, itemID INT NOT NULL, lastremoval DATE NOT NULL)");
        executeQuery("CREATE TABLE IF NOT EXISTS items (itemID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, title VARCHAR(100) NOT NULL, count INT(10) NOT NULL, manufacturerID INT(30) NOT NULL, note LONGTEXT NOT NULL)");
        executeQuery("CREATE TABLE IF NOT EXISTS types (typeID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, type VARCHAR(100) NOT NULL)");
        executeQuery("CREATE TABLE IF NOT EXISTS manufactures (manufacturerID INTEGER PRIMARY KEY AUTOINCREMENT, manufacturer VARCHAR(100) NOT NULL, note LONGTEXT NOT NULL)");
        executeQuery("CREATE TABLE IF NOT EXISTS reparings (reparingID INTEGER PRIMARY KEY AUTOINCREMENT, itemID INT NOT NULL, date INT(10) NOT NULL, costs REAL NOT NULL, reparer VARCHAR(100) NOT NULL, note LONGTEXT NOT NULL)");
        executeQuery("CREATE TABLE IF NOT EXISTS purchaseDetails (purchaseID INTEGER PRIMARY KEY AUTOINCREMENT, price REAL NOT NULL, dateofpurcahse DATE NOT NULL, boughtat VARCHAR(300) NOT NULL)");
    }

}

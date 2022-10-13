package com.example.studentdatabase.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectionManager {

    private static String hostName, userName, password;

    private static Connection con;



    public static Connection getCon() {
        hostName = "jdbc:mysql://test22v1.mysql.database.azure.com/studentDatabase";
        userName = "albert";
        password = "Kydksg5$";

        try {
            con = DriverManager.getConnection(hostName,userName,password);

        } catch (SQLException e){
            System.out.println("Connection failed : (");
            throw new RuntimeException(e);
        }
        System.out.println("Connected : )");
        return con;
    }
    static class Main{
        public static void main(String[] args) {
            DataConnectionManager.getCon();
        }
    }
}

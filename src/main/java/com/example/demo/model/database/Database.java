package com.example.demo.model.database;

import com.example.demo.model.Personel;

import java.sql.*;

public class Database {
    public static Connection getConnection(String tableName) {
        try{
            String url = "jdbc:mysql://127.0.0.1:3306/otomasyon"+tableName;
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void createTable(String sqlCommand) {
        try {
            Connection conn = getConnection("");
            PreparedStatement create = conn.prepareStatement(sqlCommand);
            create.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void insertTable(String tableName,String sqlCommand) throws SQLException {
        try {
            Connection conn = getConnection(tableName);
            Statement stmt = conn.createStatement();
            String query1 = sqlCommand;
            stmt.executeUpdate(query1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet fromTable(String tableName, String columnName, String param) throws SQLException {
        ResultSet rs = null;
        try {
            Connection conn = getConnection("");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from " + tableName + " where " + columnName + " like '" + param + "';");

            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }


}

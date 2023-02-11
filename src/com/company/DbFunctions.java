package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {

    //  create a connection to database first

    public Connection connectToDb(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }


    //  create a table

    public void createTable(Connection conn, String tableName){
        Statement statement;
        try{
            String query="create table "+tableName+"(empId SERIAL,name varchar(200),address varchar(200),primary key(empId));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }
        catch(Exception e){

        }
    }

    //  insert row

    public void insertRow(Connection conn,String tableName, String name,String address){
        Statement statement;
        try{
        String query=String.format("insert into %s(name,address) values('%s','%s');",tableName,name,address);
        statement=conn.createStatement();
        statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //  read data

    public void readData(Connection conn,String tableName){
        Statement statement;
        ResultSet resultSet=null;
        try{
            String query=String.format("select * from "+tableName);
            statement=conn.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.print(resultSet.getString("empId")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.println(resultSet.getString("address")+" ");

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
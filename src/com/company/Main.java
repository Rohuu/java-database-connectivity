package com.company;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
	DbFunctions db=new DbFunctions();
    Connection conn=db.connectToDb("db1","postgres","postgres");
//    db.createTable(conn,"employee");
//    db.insertRow(conn,"employee","Mahendra","Pune");
    db.updateName(conn,"employee","Reeta","Dolly");
    db.readData(conn,"employee");
    }

}

package ua.kiev.prog.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Example {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    static Connection conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // create connection
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package hwFlats;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/flatsdb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Func func = new Func();
        try {
            try {
                func.conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                func.initDb();
                func.Svyatoshin();
                func.Shevchenko();
                func.Pechersk();
                func.menu();






            } finally {
                if (func.conn != null) {
                    func.conn.close();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
    }


    }


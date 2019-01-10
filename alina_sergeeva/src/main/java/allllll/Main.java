package allllll;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/flats";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "@lina0661885624";

    //public static Connection con;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods ms = new Methods();

        try {
            ms.con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            ms.menuOfSearch();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



package allllll.jdbc.task2;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/myorders";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "@lina0661885624";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Code code = new Code();

        try{

            code.conn=DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            //code.initDB();
            code.menu();
        }catch (SQLException e){
            e.printStackTrace();
        }

}
}

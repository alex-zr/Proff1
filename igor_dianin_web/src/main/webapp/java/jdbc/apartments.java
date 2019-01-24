package jdbc;

import java.sql.*;
import java.util.Scanner;


public class apartments {
   public static databaseProperties databaseProperties = new databaseProperties();
    public static void main(String[] args) {


        while (true){
            System.out.println("database check with - statement");
            System.out.println("1: add client");
            System.out.println("2: delete client");
            System.out.println("3: view clients");
            System.out.print("-> ");

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            switch (s) {
                case "1" :
                    addApartment();
                    break;
                case "2" :
                    deleteApartmentAll();
                    break;
                case "3" :
                    viewApartment();
                    break;
                default:
                    return;
            }

        }
    }

    private static void viewApartment() {
        String SQL = "SELECT * FROM apartment";
        try {
            Connection connection = DriverManager.getConnection(
                    databaseProperties.getURL(),databaseProperties.getUSER(), databaseProperties.getPASSWORD());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String district = resultSet.getString(2);
                String address = resultSet.getString(3);
                String square = resultSet.getString(4);
                int number_of_rooms = resultSet.getInt(5);
                Integer price = resultSet.getInt(6);
                System.out.println("id" + id);
                System.out.println("district" + district);
                System.out.println("address" + address);
                System.out.println("square" + square);
                System.out.println("number_of_rooms" + number_of_rooms);
                System.out.println("price" + price);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("could connect to database");
        }
    }

    private static void deleteApartmentAll() {
        try {
            Connection connection = DriverManager.getConnection(
                    databaseProperties.getURL(),databaseProperties.getUSER(), databaseProperties.getPASSWORD());
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM apartment");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("could not connect to the database");
        }
    }

    private static void addApartment() {

        try {
            Connection connection = DriverManager.
                    getConnection(
                    databaseProperties.getURL(), databaseProperties.getUSER(), databaseProperties.getPASSWORD());
            Statement statement = connection.createStatement();

            try {
                statement.executeUpdate(
                        "INSERT INTO apartment (district, address, square, number_of_rooms, price) VALUES ('Micurina','24/76','18','3','35000')");
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("cant add in database");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("could not connect to the database");
        }

    }


}

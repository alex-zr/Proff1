package brodovskyyaroslav.gmail.com;

import java.sql.*;
import java.util.Scanner;

public class ApartmentsDB {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartment";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "*****";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            try (Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
                while(true) {
                    System.out.println("1: add apartment");
                    System.out.println("2: delete apartment");
                    System.out.println("3: change apartment");
                    System.out.println("4: view apartments");
                    System.out.println("5: view apartments with params");
                    System.out.print("-> ");

                    String action = sc.nextLine();

                    switch( action ) {
                        case "1":
                            addApartment(sc, conn);
                            break;

                        case "2":
                            deleteApartment(sc, conn);
                            break;

                        case "3":
                            changeApartmentData(sc, conn);
                            break;

                        case "4":
                            viewApartments(conn);
                            break;

                        case "5":
                            viewApartmentsWithParams(sc, conn);
                            break;

                        default:
                            sc.close();
                            return;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addApartment(Scanner sc, Connection conn) {
        System.out.println("Enter apartment square:");
        String sq = sc.nextLine();
        System.out.println("Enter apartment rooms:");
        String room = sc.nextLine();
        System.out.println("Enter apartment price:");
        String pr = sc.nextLine();
        System.out.println("Enter apartment adress:");
        String address = sc.nextLine();

        int price = Integer.parseInt(pr);
        int square = Integer.parseInt(sq);
        int rooms = Integer.parseInt(room);

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO flat (square, rooms, price, address) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, square);
            statement.setInt(2, rooms);
            statement.setInt(3, price);
            statement.setString(4, address);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteApartment(Scanner sc, Connection conn) {
        System.out.println("Enter apartment address, rooms, price to delete:");
        String address = sc.nextLine();
        String room = sc.nextLine();
        String pr = sc.nextLine();

        int rooms = Integer.parseInt(room);
        int price = Integer.parseInt(pr);

        try ( PreparedStatement statement = conn.prepareStatement("DELETE FROM flat WHERE address = ? AND rooms = ? AND price = ?") ) {
            statement.setString(1, address);
            statement.setInt(2, rooms);
            statement.setInt(3, price);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void changeApartmentData(Scanner sc, Connection conn) {
        System.out.println("Enter apartment's address and amount of rooms");
        String address = sc.nextLine();
        String room = sc.nextLine();

        System.out.println("Enter new price for the apartment:");
        String pr = sc.nextLine();

        int rooms = Integer.parseInt(room);
        int price = Integer.parseInt(pr);

        try ( PreparedStatement statement = conn.prepareStatement("UPDATE flat SET price = ? WHERE address = ? AND rooms = ?") ) {
            statement.setInt(1, price);
            statement.setString(2, address);
            statement.setInt(3, rooms);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void viewApartments(Connection conn) {
        try ( PreparedStatement statement = conn.prepareStatement("SELECT *FROM flat") ) {
            try ( ResultSet rs = statement.executeQuery() ) {
                ResultSetMetaData md = rs.getMetaData();

                for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while( rs.next() ) {
                    for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                        System.out.print(rs.getString(i) + "\t\t\t");
                    }

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void viewApartmentsWithParams(Scanner sc, Connection conn) {
        System.out.println("Enter interested param, search param and values:");
        String intParam = sc.nextLine();
        System.out.println("search param:");
        String param = sc.nextLine();
        System.out.println("value:");
        String value = sc.nextLine();

        try ( PreparedStatement statement = conn.prepareStatement("SELECT " + intParam + " FROM flat WHERE " + param +
                "= " + value) ) {
            try ( ResultSet rs = statement.executeQuery() ) {
                ResultSetMetaData md = rs.getMetaData();

                for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while( rs.next() ) {
                    for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                        System.out.print(rs.getString(i) + "\t\t\t");
                    }

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

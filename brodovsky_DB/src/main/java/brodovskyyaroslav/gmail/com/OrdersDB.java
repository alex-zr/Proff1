package brodovskyyaroslav.gmail.com;

import java.sql.*;
import java.util.Scanner;

public class OrdersDB {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/orderdb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "*****";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            try ( Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
                while(true) {
                    System.out.println("1: add new client");
                    System.out.println("2: make a new order");
                    System.out.println("3: add new goods");
                    System.out.println("4: update orders");
                    System.out.println("5: client list");
                    System.out.println("6: goods list");
                    System.out.println("7: orders list");
                    System.out.print("->");

                    String action = sc.nextLine();

                    switch (action) {
                        case "1":
                            newClient(sc, conn);
                            break;

                        case "2":
                            newOrder(sc, conn);
                            break;

                        case "3":
                            newGoods(sc, conn);
                            break;

                        case "4":
                            updateOrders(sc, conn);
                            break;


                        case "5":
                            clientsList(conn);
                            break;

                        case "6":
                            goodsList(conn);
                            break;

                        case "7":
                            ordersList(conn);
                            break;

                        default:
                            sc.close();
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void newClient(Scanner sc, Connection conn) {
        System.out.println("Enter client info");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Surname:");
        String surname = sc.nextLine();
        System.out.println("Phone number:");
        String phone = sc.nextLine();

        try ( PreparedStatement statement = conn.prepareStatement("INSERT INTO clients (name, surname, phone) VALUES (?, ?, ?)") ) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, phone);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void newOrder(Scanner sc, Connection conn) {
        System.out.println("Enter order info:");
        System.out.println("Amount of ordered goods");
        String amount = sc.nextLine();
        System.out.println("Goods id:");
        String goodsId = sc.nextLine();
        System.out.println("Client id:");
        String clientId = sc.nextLine();

        int am = Integer.parseInt(amount);
        int gId = Integer.parseInt(goodsId);
        int cId = Integer.parseInt(clientId);

        try ( PreparedStatement statement = conn.prepareStatement("INSERT INTO orders (amount, goods_id, client_id) VALUES (?, ?, ?)") ) {
            statement.setInt(1, am);
            statement.setInt(2, gId);
            statement.setInt(3, cId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void newGoods(Scanner sc, Connection conn) {
        System.out.println("Enter goods info:");
        System.out.println("Goods type");
        String type = sc.nextLine();
        System.out.println("Goods name:");
        String name = sc.nextLine();

        try ( PreparedStatement statement = conn.prepareStatement("INSERT INTO goods (goods_type, goods_name) VALUES (?, ?)") ) {
            statement.setString(1, type);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void updateOrders(Scanner sc, Connection conn) {
        System.out.println("Enter new order info:");
        System.out.println("goods_id:");
        String goods = sc.nextLine();
        System.out.println("client_id");
        String client = sc.nextLine();

        try ( PreparedStatement statement = conn.prepareStatement("UPDATE orders WHERE goods_id= ? AND client_id= ?") ) {
            statement.setString(1, goods);
            statement.setString(2, client);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void clientsList(Connection conn) {
        try ( PreparedStatement statement = conn.prepareStatement("SELECT *FROM clients") ) {
            try ( ResultSet rs = statement.executeQuery() ) {
                ResultSetMetaData md = rs.getMetaData();

                for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while( rs.next() ) {
                    for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void goodsList(Connection conn) {
        try ( PreparedStatement statement = conn.prepareStatement("SELECT *FROM goods") ) {
            try ( ResultSet rs =  statement.executeQuery() ) {
                ResultSetMetaData md = rs.getMetaData();

                for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while ( rs.next() ) {
                    for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void ordersList(Connection conn) {
        try ( PreparedStatement statement = conn.prepareStatement("SELECT *FROM orders") ) {
            try ( ResultSet rs = statement.executeQuery() ) {
                ResultSetMetaData md = rs.getMetaData();

                for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while ( rs.next() ) {
                    for ( int i = 1; i <= md.getColumnCount(); i++ ) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

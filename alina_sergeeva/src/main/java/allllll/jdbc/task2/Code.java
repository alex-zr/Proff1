package allllll.jdbc.task2;

import java.sql.*;
import java.util.Scanner;

public class Code {
    public static Connection conn;


    public static void initDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS goods");
            st.execute("CREATE TABLE goods (id_goods INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name_goods VARCHAR(40) NOT NULL UNIQUE KEY, quantity_goods INT NOT NULL, price_goods INT NOT NULL)");

            st.execute("DROP TABLE IF EXISTS clients");
            st.execute("CREATE TABLE clients (id_clients INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name_clients VARCHAR(30) NOT NULL, phone_clients INT NOT NULL UNIQUE KEY )");

            st.execute("DROP TABLE IF EXISTS orders");
            st.execute("CREATE TABLE orders(id_orders INT NOT NULL AUTO_INCREMENT PRIMARY KEY, orders_goods VARCHAR(30) NOT NULL, orders_clients INT NOT NULL, orders_quantity INT NOT NULL, orders_price INT NOT NULL, orders_total_price INT DEFAULT NULL)");

        } finally {
            st.close();
        }

    }

    private static void addNewClients(Scanner sc) throws SQLException {
        System.out.println("Введите имя клиента:");
        String name = sc.nextLine();
        System.out.println("Введите номер телефона клиента:");
        String phone = sc.nextLine();
        int ph = Integer.parseInt(phone);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO clients(name_clients, phone_clients) VALUES (?,?)");
        try {
            ps.setString(1, name);
            ps.setInt(2, ph);
            ps.executeUpdate();

        } finally {
            ps.close();
        }

    }

    private static void addNewGoods(Scanner sc) throws SQLException {
        System.out.println("Введите название товара:");
        String name = sc.nextLine();
        System.out.println("Введите количество товара:");
        String quantity = sc.nextLine();
        int qu = Integer.parseInt(quantity);
        System.out.println("Введите цену товара за 1 шт:");
        String price = sc.nextLine();
        int st = Integer.parseInt(price);

        PreparedStatement ps = conn.prepareStatement("INSERT INTO goods(name_goods,quantity_goods,price_goods) VALUES (?,?,?)");
        try {
            ps.setString(1, name);
            ps.setInt(2, qu);
            ps.setInt(3, st);
            ps.executeUpdate();


        } finally {
            ps.close();
        }
    }

    private static void addNewOrders(Scanner sc) throws SQLException {
        System.out.println("Введите номер телефона клиента:");
        String phone = sc.nextLine();
        System.out.println("Введите название товара:");
        String nameOfGoods = sc.nextLine();
        System.out.println("Введите количество товара:");
        String quantityOfGoods = sc.nextLine();
        int orders_quantity = Integer.parseInt(quantityOfGoods);

        int orders_clients = 0;

        try {PreparedStatement ps = conn.prepareStatement("SELECT phone_clients FROM clients WHERE phone_clients=" + phone);
            ResultSet rs = ps.executeQuery();
            try {
                if (rs.next()) {
                    orders_clients = Integer.parseInt(rs.getString(1));
                }
            } finally {
                rs.close();
                ps.close();
            }

        } finally {
        }
        String orders_goods = null;
        try{
        PreparedStatement ps = conn.prepareStatement("SELECT name_goods FROM goods WHERE name_goods ="+nameOfGoods);
            ResultSet rs = ps.executeQuery();
            try{
                if(rs.next()){
                    orders_goods=rs.getString(1);
                }
            }finally {
                rs.close();
                ps.close();}

            }finally{

            }
        int orders_price = 0;
        try {PreparedStatement ps = conn.prepareStatement("SELECT price_goods FROM goods WHERE name_goods="+nameOfGoods);
            ResultSet rs = ps.executeQuery();
            try{
                if(rs.next()){
                    orders_price = Integer.parseInt(rs.getString(1));
                }
            }finally {
                rs.close();
                ps.close();
            }
        }finally {

        }

        int orders_total_price = 0;
        try{PreparedStatement ps = conn.prepareStatement("SELECT price_goods FROM goods WHERE name_goods="+nameOfGoods);
            ResultSet rs = ps.executeQuery();
            try{
                if(rs.next()){
                    orders_total_price=orders_price*orders_quantity;
                }
            }finally {
                rs.close();
                ps.close();
            }
            }finally {

        }
        PreparedStatement ps = conn.prepareStatement("INSERT INTO orders(orders_clients,orders_goods,orders_quantity,orders_price,orders_total_price) VALUES (?,?,?,?,?)");
        try{
            ps.setInt(1,orders_clients);
            ps.setString(2,orders_goods);
            ps.setInt(3,orders_quantity);
            ps.setInt(4,orders_price);
            ps.setInt(5,orders_total_price);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
            }
    public static void Base_clients(Scanner sc) throws SQLException {
        Statement ps = conn.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT * FROM clients");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }
    public static void Base_goods(Scanner sc) throws SQLException {
        Statement ps = conn.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT * FROM goods");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }
    public static void Base_orders(Scanner sc) throws SQLException {
        Statement ps = conn.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT * FROM orders");
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }
public void menu()throws SQLException{
    Scanner sc = new Scanner(System.in);
    System.out.println("1- добавить нового клиента");
    System.out.println("2- добавить новый товар");
    System.out.println("3- оформить заказ");
    System.out.println("4- показать базу клиентов");
    System.out.println("5- показать базу товаров");
    System.out.println("6- показать базу заказов");
    System.out.println("7- выйти");
    System.out.print("-> ");

    String s = sc.nextLine();
    switch (s) {
        case "1":
            addNewClients(sc);
            menu();
            break;
        case "2":
            addNewGoods(sc);
            menu();
            break;
        case "3":
            addNewOrders(sc);
            menu();
            break;
        case "4":
            Base_clients(sc);
            menu();
        case "5":
            Base_goods(sc);
            menu();
        case "6":
            Base_orders(sc);
            menu();
        case "7":
            break;
    }
    }}


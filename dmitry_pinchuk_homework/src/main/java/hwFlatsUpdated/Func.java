package hwFlatsUpdated;

import java.sql.*;
import java.util.Scanner;

public class Func {

    public static Connection conn;

    public static void initDb() throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("drop table if exists flats");
            st.execute("create table flats (id int not null auto_increment primary key, district varchar (30) default null , address varchar(128) default null , square int default null , rooms int default null, price varchar(128) default null )");

            conn.setAutoCommit(false);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        }
    }


        public static void pechersk()throws SQLException{
            try (PreparedStatement prepare = conn.prepareStatement("insert into flats (district,address,square,rooms,price) values(?,?,?,?,?)")) {
                conn.setAutoCommit(false);
                String r = "Pechersk";
                String a = "Lesi Ukraine";
                int c = 47;
                int d = 2;
                String s = "100000$";
                prepare.setString(1, r);
                prepare.setString(2, a);
                prepare.setInt(3, c);
                prepare.setInt(4, d);
                prepare.setString(5, s);
                prepare.executeUpdate();
                conn.commit();

            }catch (Exception e){
                conn.rollback();
            }
        }
        public static void svyatoshin() throws SQLException{
            try (PreparedStatement prepare = conn.prepareStatement("insert into flats (district,address,square,rooms,price) values(?,?,?,?,?)")) {
                conn.setAutoCommit(false);
                String svyat = "Svyatoshin";
                String proriz = "Prorizna";
                int sd = 63;
                int rss = 3;
                String prs = "85000$";
                prepare.setString(1, svyat);
                prepare.setString(2, proriz);
                prepare.setInt(3, sd);
                prepare.setInt(4, rss);
                prepare.setString(5, prs);
                prepare.executeUpdate();
                conn.commit();

            }catch (Exception e){
                conn.rollback();
            }
        }

        public static void shevchenko() throws SQLException{
            try (PreparedStatement prepare = conn.prepareStatement("insert into flats (district,address,square,rooms,price) values(?,?,?,?,?)")) {
                conn.setAutoCommit(false);
                String sheva = "Shevchenko";
                String derevlyanka = "Derevlyanka";
                int sq = 35;
                int rooms = 1;
                String pr = "45000$";
                prepare.setString(1, sheva);
                prepare.setString(2, derevlyanka);
                prepare.setInt(3, sq);
                prepare.setInt(4, rooms);
                prepare.setString(5, pr);
                prepare.executeUpdate();
                conn.commit();

            }catch (Exception e){
                conn.rollback();
            }
        }



    public static void menu()throws SQLException{
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose one of the varients of flats for parameters");
            System.out.println("1: district");
            System.out.println("2: address");
            System.out.println("3: square");
            System.out.println("4: rooms");
            System.out.println("5: price");
            System.out.println("6: view flats");
            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    districtFlats(sc);
                    break;
                case "2":
                    addressFlats(sc);
                    break;
                case "3":
                    squareFlats(sc);
                    break;
                case "4":
                    roomsFlats(sc);
                    break;
                case "5":
                    priceFlats(sc);
                    break;
                case "6":
                    viewFlats();
                    break;
                default:
                    return;
            }
        }
    }

    public static void districtFlats (Scanner sc) throws SQLException {
        System.out.println("Enter your preferred district of flat");
        String se = sc.nextLine();
        try (PreparedStatement ps = conn.prepareStatement("select * from flats")) {

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        String districtName = rs.getString("district");
                        if (se.equals(districtName)) {
                            System.out.print(rs.getString(i) + "\t\t");

                        }

                    }
                }
                System.out.println();

            }

        }

    }

    public static void addressFlats (Scanner sc) throws SQLException {
        System.out.println("Enter your preferred address of flat");
        String se = sc.nextLine();
        try (PreparedStatement ps = conn.prepareStatement("select * from flats")) {

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        String addressName = rs.getString("address");
                        if (se.equals(addressName)) {
                            System.out.print(rs.getString(i)+"\t\t");
                        }
                    }

                }
                System.out.println();
            }

        }

    }

    public static void squareFlats (Scanner sc) throws SQLException {
        System.out.println("Enter your preferred square of flat");
        String se = sc.nextLine();
        int square = Integer.parseInt(se);
        try (PreparedStatement ps = conn.prepareStatement("select * from flats")) {

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        int squareFlat = rs.getInt("square");
                        if (square == squareFlat) {
                            System.out.print(rs.getString(i)+"\t\t");
                        }
                    }

                }
                System.out.println();
            }

        }

    }

    public static void roomsFlats (Scanner sc) throws SQLException {
        System.out.println("Enter your preferred rooms of flat");
        String se = sc.nextLine();
        int room = Integer.parseInt(se);
        try (PreparedStatement ps = conn.prepareStatement("select * from flats")) {

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        int roomsFlat = rs.getInt("rooms");
                        if (room == roomsFlat) {
                            System.out.print(rs.getString(i)+"\t\t");
                        }
                    }
                }
                System.out.println();
            }

        }

    }
    public static void priceFlats (Scanner sc) throws SQLException {
        System.out.println("Enter your preferred price of flat");
        String se = sc.nextLine();

        try (PreparedStatement ps = conn.prepareStatement("select * from flats")) {

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        String priceFlat = rs.getString("price");
                        if (se.equals(priceFlat)) {
                            System.out.print(rs.getString(i)+"\t\t");
                        }
                    }
                }
                System.out.println();
            }

        }

    }
    public static void viewFlats () throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM flats");
        try {

            ResultSet rs = ps.executeQuery();
            try {

                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i)+"\t\t");
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
//
}


package allllll;

import javax.persistence.Column;
import java.sql.*;
import java.util.Scanner;

public class Methods {
    public static Connection con;

    public static void allApartments() throws SQLException {
        Statement ps = con.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT * FROM flats");
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

    public void searchOfRooms(int a, int b) throws SQLException {
        Statement ps = con.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT* FROM flats WHERE rooms>=" + a + " AND rooms <=" + b);

            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                if (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                } else {
                    System.out.println("Квартир с таким количеством комнат не существует");
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }


    }

    public void searchOfArea(int a, int b) throws SQLException {
        Statement ps = con.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT* FROM flats WHERE area>=" + a + " AND area<=" + b);
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                if (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }else{
                    System.out.println("Квартир с такой площадью не существует");
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }

    }


    public void searchOfPrice(int a, int b) throws SQLException {
        Statement ps = con.createStatement();
        try {
            ResultSet rs = ps.executeQuery("SELECT* FROM flats WHERE prise>=" + a + " AND prise<=" + b);
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();
                if (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }else {
                    System.out.println("Квартир с такой ценой не существует");
                }

            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }

    }

    public void searchOfRegion(String a) throws SQLException {
        Statement ps = con.createStatement();
        try (ResultSet rs = ps.executeQuery("SELECT* FROM flats WHERE region=" + a)) {

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


    public void menuOfSearch() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Сортировать по количеству комнат");
        System.out.println("2- Сортировать по площади квартиры");
        System.out.println("3- Сортировать по цене");
        System.out.println("4- Сортировать по району");
        System.out.println("5- Показать все квартиры");
        System.out.println("6- Выход из меню");
        System.out.print("-> ");

        String s = sc.nextLine();
        switch (s) {
            case "1":
                System.out.println("Укажите количество комнат от:");
                String aa = sc.nextLine();
                System.out.println("до:");
                String bb = sc.nextLine();
                int a = Integer.parseInt(aa);
                int b = Integer.parseInt(bb);
                searchOfRooms(a, b);
                menuOfSearch();
                break;
            case "2":
                System.out.println("Укажите желаемую площадь квартиры от:");
                String cc = sc.nextLine();
                System.out.println("до:");
                String dd = sc.nextLine();
                int c = Integer.parseInt(cc);
                int d = Integer.parseInt(dd);
                searchOfArea(c, d);
                menuOfSearch();
                break;
            case "3":
                System.out.println("Укажите желаемую цену квартиры от:");
                String ee = sc.nextLine();
                System.out.println("до:");
                String ff = sc.nextLine();
                int e = Integer.parseInt(ee);
                int f = Integer.parseInt(ff);
                searchOfPrice(e, f);
                menuOfSearch();
                break;
            case "4":
                System.out.println("Укажите желаемый район:");
                String gg = sc.nextLine();
                searchOfRegion(gg);
                menuOfSearch();
                break;
            case "5":
                allApartments();
                menuOfSearch();
                break;
            case "6":
                break;


        }


    }
}

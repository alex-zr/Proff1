package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class customer {
    public static databaseCustomerProperties databaseCustomerProperties = new databaseCustomerProperties();

    static Connection connection;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            connection = DriverManager.getConnection(
                    databaseCustomerProperties.getURL(), databaseCustomerProperties.getUSER(),
                    databaseCustomerProperties.getPASSWORD());
            while (true){

                System.out.println("PreparedStatement");
                System.out.println("Select...");
                System.out.println("1 - add product");
                System.out.println("2 - add client");
                System.out.println("3 - add order");
                System.out.println("4 - delete product");
                System.out.println("5 - delete client");
                System.out.println("6 - delete order");
                System.out.println("7 - edit product");
                System.out.println("8 - edit client");
                System.out.println("9 - edit order");
                System.out.println("10 - show product");
                System.out.println("11 - show client");
                System.out.println("12 - show order");


                String s = scanner.nextLine();

                switch (s){
                    case "1" :
                        addProduct();
                        break;
                    case "2" :
                        addClient();
                        break;
                    case "3" :
                        addOrder();
                        break;
                    case "4" :
                        deleteProduct();
                        break;
                    case "5" :
                        deleteClient();
                        break;
                    case "6" :
                        deleteOrder();
                        break;
                    case "7" :
                        edtProduct();
                        break;
                    case "8" :
                        editProduct();
                        break;
                    case "9" :
                        editProduct();
                        break;
                    case "10" :
                        addProduct();
                        break;
                    case "11" :
                        addProduct();
                        break;
                    case "12" :
                        addProduct();
                        break;
                    default:
                        return;

                }



        }




    }



    private static void addProduct() {



    }

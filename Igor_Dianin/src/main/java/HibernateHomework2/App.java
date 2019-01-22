package HibernateHomework2;


import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        BankDAO bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        try {

            bank.initialDB();
            while (true){
                System.out.println("");
                System.out.println("1.Add user");
                System.out.println("2.Delete user");
                System.out.println("3.Add account");
                System.out.println("4.Delete account");
                System.out.println("5.Replenish Account");
                System.out.println("6.Transfer Money");
                System.out.println("7.Convert Currency");
                System.out.println("8.View Total Amount Of Money In The Account UAH ");


                String s = scanner.nextLine();
                switch (s){
                    case "1" :
                        bank.addUser();
                        break;
                    case "2" :
                        bank.deleteUser();
                        break;
                    case "3" :
                        bank.addAccount();
                        break;
                    case "4" :
                        bank.deleteAccount();
                        break;
                    case "5" :
                        bank.replenishAccount();
                        break;
                    case "6" :
                        bank.transferMoney();
                        break;
                    case "7" :
                        bank.convertCurrency();
                        break;
                    case "8" :
                        bank.viewTotalAmountOfMoneyInTheAccountUAH();
                        break;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong..");
        } finally {
            bank.closeDB();
            System.out.println("Thank you for using our bank!");
        }


    }

}



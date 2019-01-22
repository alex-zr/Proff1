package HibernateHomework2;



import jdk.management.resource.internal.inst.UnixAsynchronousSocketChannelImplRMHooks;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

public class Bank implements BankDAO {
        private EntityManagerFactory entityManagerFactory;
        private EntityManager entityManager;
        static Scanner scanner;


    @Override
    public void initialDB() {
       entityManagerFactory = Persistence.createEntityManagerFactory("Bank");
        entityManager = entityManagerFactory.createEntityManager();
        scanner = new Scanner(System.in);
    }

    @Override
    public void closeDB() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void addUser() {

        System.out.print("Enter username:");
        String name = scanner.nextLine();
        System.out.print("Enter phone number:");
        String phone = scanner.nextLine();
        entityManager.getTransaction().begin();
        try {
            User user = new User(name,phone);
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Can not add");
            e.printStackTrace();
            addUser();
        }

    }

    @Override
    public void deleteUser() {
        System.out.println("Write id");
        long id = scanner.nextLong();
        User user = entityManager.find(User.class, id);
        if (user==null){
            System.out.println("User do not exist! Write correct!");
            deleteUser();
        }
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void addAccount() {
        System.out.println("write your username");
        String username = scanner.nextLine();
        System.out.println("write your number");
        String number = scanner.nextLine();
        Query query = entityManager.createQuery("SELECT  u from user u WHERE u.name=:name AND u.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<User>users = query.getResultList();
        User user = users.get(0);
       if (user==null){
           System.out.println("User do not exist");
           addAccount();
       }
        System.out.println("Choose currency");
        System.out.println("1 - UAH");
        System.out.println("2 - EUR");
        System.out.println("3 - USD");
        String currency = scanner.nextLine();
        switch (currency){
            case "1" :
                currency="UAH";
                break;
            case "2" :
                currency="EUR";
                break;
            case "3" :
                currency="USD";
                break;
                default:
                    return;
        }

        try {
            entityManager.getTransaction().begin();
            Account account = new Account(user,currency);
            entityManager.persist(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("somebody is wrong!");
            entityManager.getTransaction().rollback();
        }


    }

    @Override
    public void deleteAccount() {

        System.out.println("Write a username");
        String username = scanner.nextLine();
        System.out.println("Write a number");
        String number = scanner.nextLine();
        Query query = entityManager.createQuery(
                "from account e where e.user.name=:name AND e.user.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<Account> accounts = query.getResultList();
        if (accounts == null) {
            System.out.println("You don't have a accounts");
            System.out.println("Write one more:");
            deleteAccount();
        } else {
            System.out.println("Select account for deleted");
            System.out.println("Write id account to deleted");
            accounts.forEach(System.out::println);
        }
        String accountId = scanner.nextLine();
        Long accountIdLong = Long.parseLong(accountId);
        Account account = entityManager.find(Account.class, accountIdLong);
        if ((account.getAmountOfCurrencyUAH()+account.getAmountOfCurrencyUSD()+account.getAmountOfCurrencyEUR()>0)) {
            System.out.println(
                    "account" + account.getId() + "have money " );
        } else {
            entityManager.getTransaction().begin();

            try {
                entityManager.remove(account);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
                System.out.println("account with id " + accountIdLong + "can't exist");
                deleteAccount();
            }
        }
    }

    @Override
    public void replenishAccount() {

        System.out.println("write username");
        String username = scanner.nextLine();
        System.out.println("Write your number");
        String number =  scanner.nextLine();
        Query query = entityManager.createQuery(" from account e where e.user.name=:name AND e.user.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<Account>accounts = query.getResultList();
        if (accounts.isEmpty()){
            System.out.println("This username don't have a accounts");
            replenishAccount();
        } else {
            System.out.println("Choose account to for replenishment");
            System.out.println("Choose and write account:");
            accounts.forEach(System.out::println);
        }
        Long idAccount = scanner.nextLong();
        Account account =entityManager.find(Account.class, idAccount);
        entityManager.getTransaction().begin();
        try {
            System.out.println("Choose currency");
            String currency = scanner.nextLine();
            System.out.println("How much of currency?");
            float amount = scanner.nextLong();
            switch (currency){
                case "1" :
                    currency = "USD";
                    account.addAmountOfCurrencyUSD(amount);
                    entityManager.refresh(account);
                    break;
                case "2" :
                    currency = "EUR";
                    account.addAmountOfCurrencyEUR(amount);
                    entityManager.refresh(account);
                    break;
                case "3" :
                    currency = "UAH";
                    account.addAmountOfCurrencyUAH(amount);
                    entityManager.refresh(account);
                    break;
                    default:
                        System.out.println("somebody wrong!");
                        System.out.println("write 1 or 2 or 3 to choose");
                        replenishAccount();
            }
            entityManager.getTransaction().commit();
            System.out.println("your account has been sent to" + amount + " " + currency);
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            System.out.println("Some problems with transaction");
        }



    }


    @Override
    public void transferMoney() {

        System.out.println("write username");
        String username = scanner.nextLine();
        System.out.println("Write your number");
        String number =  scanner.nextLine();
        Query query = entityManager.createQuery(" from account e where e.user.name=:name AND e.user.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<Account>accounts = query.getResultList();
        if (accounts.isEmpty()){
            System.out.println("This username don't have a accounts");
            replenishAccount();
        } else {
            System.out.println("Choose  account to for replenishment");
            System.out.println("Choose and  write account:");
            accounts.forEach(System.out::  println);
        }
        Long idAccount = scanner.nextLong();
        Account account =entityManager.find(Account.class, idAccount);

        System.out.println("enter the amount of UAH you want to transfer ");
        float amount = scanner.nextFloat();
        System.out.println("Write number account recipient");
        String numberResepient = scanner.nextLine();
        Query query1 = entityManager.createQuery("from account e where e.user.number=:number");
        query1.setParameter("number",numberResepient);
        List<Account>accountList = query1.getResultList();
        Account accountRecepient = accountList.get(0);
        if (accountList.isEmpty()){
            System.out.println("Account not exist or not enough money!");
            transferMoney();
        } else{
            entityManager.getTransaction().begin();
            try {
                account.pullOffAmountOfCurrencyUAH(amount);
                accountRecepient.addAmountOfCurrencyUAH(amount);
                entityManager.getTransaction().commit();
                System.out.println("completed!");
            } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
            }


        }
    }

    @Override
    public void convertCurrency() {
        System.out.println("write username");
        String username = scanner.nextLine();
        System.out.println("Write your number");
        String number =  scanner.nextLine();
        Query query = entityManager.createQuery(" from account e where e.user.name=:name AND e.user.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<Account>accounts = query.getResultList();
        if (accounts.isEmpty()){
            System.out.println("This username don't have a accounts");
            replenishAccount();
        } else {
            System.out.println("Choose  account to for replenishment");
            System.out.println("Choose and write account:");
            accounts.forEach(System.out:: println);
        }
        Long idAccount = scanner.nextLong();
        Account account =entityManager.find(Account.class, idAccount);

        System.out.println("write amount of currency you want to sell");
        float currency = scanner.nextFloat();
        System.out.println("choose the currency you want to sell");
        System.out.println("please write currency");
        System.out.println("for example UAH");
        System.out.println("UAH");
        System.out.println("EUR");
        System.out.println("USD");
        String sell = scanner.nextLine();
        String addedVariable;
        if (sell.equalsIgnoreCase("UAH")){             //Простите, это мой костыль для упрощения
            addedVariable="amountOfCurrencyUAH";                    //учебного проекта
        } else if (sell.equalsIgnoreCase("EUR")){      //Ввожу дополнительную переменную по которой
            addedVariable="amountOfCurrencyEUR";                    //в зависимости от выбраного UAH, USD, EURO
        } else addedVariable="amountOfCurrencyUSD";                 //будет подставляться правильное поле в query1

        Query query1 = entityManager.createQuery("select :amount from account a where id=:id");
        query1.setParameter("amount",addedVariable);
        query1.setParameter("id", idAccount);
        float rezultAmount = query1.getFirstResult();
        if (rezultAmount<currency){
            System.out.println("not enough money");
            convertCurrency();
        }
        System.out.println("choose the currency you want to buy");
        System.out.println("UAH");
        System.out.println("EUR");
        System.out.println("USD");
        String buy = scanner.nextLine();

        Query query2 = entityManager.createQuery("select :name1 from currency c  where name=:name2");
        query2.setParameter("name1",sell);
        query2.setParameter("name2",buy);
        float coefficient = query2.getFirstResult();


            entityManager.getTransaction().begin();
        try {
            if (sell.equalsIgnoreCase("UAH")){
                account.pullOffAmountOfCurrencyUAH(currency*(1/coefficient));
            } else if (sell.equalsIgnoreCase("EUR")) {
                account.pullOffAmountOfCurrencyEUR(currency*(1/coefficient));
            } else { account.pullOffAmountOfCurrencyUSD(currency*(1/coefficient));}

            if (buy.equalsIgnoreCase("UAH")){
                account.addAmountOfCurrencyUAH(currency*coefficient);
            } else if (buy.equalsIgnoreCase("EUR")){
                account.addAmountOfCurrencyEUR(currency*coefficient);
            } else {account.addAmountOfCurrencyUSD(currency*coefficient);}
            entityManager.getTransaction().commit();
            System.out.println("Completed!");
            System.out.println("You sell" + currency + " " + sell + "and buy" + currency*coefficient + " " + buy);
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void viewTotalAmountOfMoneyInTheAccountUAH() {

        System.out.println("write username");
        String username = scanner.nextLine();
        System.out.println("Write your number");
        String number =  scanner.nextLine();
        Query query = entityManager.createQuery(" from account e where e.user.name=:name AND e.user.number=:number");
        query.setParameter("name", username);
        query.setParameter("number", number);
        List<Account>accounts = query.getResultList();
        if (accounts.isEmpty()){
            System.out.println("This username don't have a accounts");
            replenishAccount();
        } else {
            System.out.println("Choose account to  for replenishment");
            System.out.println("Choose and write account:");
            accounts.forEach(System.out::println );
        }
        Long idAccount = scanner.nextLong();
        Account account =entityManager.find(Account.class, idAccount);
        float totalAmountUAH=
                account.getAmountOfCurrencyUAH()+
                        convertToUAH(account.getAmountOfCurrencyUSD(),"courseUSD") +
                        convertToUAH(account.getAmountOfCurrencyEUR(),"courseEUR");
        System.out.println("Total of amount of currency in UAH: " + totalAmountUAH);




    }

    @Override
    public void setCourse() {
        Date date = new Date();
        System.out.println("Hi administrator! Set the exchange rate for today!" + date);
        System.out.println("exchange rate for USD/UAH");
        float rateUSD = scanner.nextFloat();
        System.out.println("exchange rate for EUR/UAH");
        float rateEUR = scanner.nextFloat();
        System.out.println("exchange rate for USD/EUR");
        float rateUSDtoEUR = scanner.nextFloat();
        Currency USD = new Currency("USD",1,rateUSD,rateUSDtoEUR);
        Currency EUR = new Currency("EUR",1/rateUSDtoEUR, rateEUR,1);
        Currency UAH = new Currency("UAH", 1/rateUSD,1, 1/rateEUR);
        try {
            entityManager.getTransaction().begin();
            entityManager.refresh(UAH);
            entityManager.refresh(USD);
            entityManager.refresh(EUR);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Try again!");
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public float convertToUAH(float quantity, String currency) {
        float course = 0;
        try {
            Query query = entityManager.createQuery("select courseUAH from currency where name=:currency", Currency.class);
            query.setParameter("currency", currency);
            course = query.getFirstResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("problems to get a course");
            System.out.println("Rty again...");

        }
        return quantity * course;
    }


}

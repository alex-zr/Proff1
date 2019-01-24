package HibernateHomework2;

public interface BankDAO {

    void initialDB();
    void closeDB();
    void addUser();
    void deleteUser();
    void addAccount();
    void deleteAccount();
    void replenishAccount();
    void transferMoney();
    void convertCurrency();
    void viewTotalAmountOfMoneyInTheAccountUAH();
    void setCourse();
    float convertToUAH(float quantity, String currency);



}

package HibernateHomework2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "AllAccounts", query = "SELECT a FROM account a"),
        @NamedQuery(name = "Select Account where id ?", query = "SELECT a FROM account a WHERE id=:id_number")
        })
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountSender")
    private Set<Transaction> sentTransactions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountRecipient")
    private Set<Transaction> receivedTransaction;

    @Column(name = "currency")
    private String currency;

    @Column(name = "total_amount_UAH")
    private float totalAmountUAH;

    @Column(name = "amount_of_currency_UAH")
    private float amountOfCurrencyUAH;

    @Column(name = "amount_of_currency_USD")
    private float amountOfCurrencyUSD;

    @Column(name = "amount_of_currency_EUR")
    private float amountOfCurrencyEUR;

    public Account(User user, String currency) {
        this.user = user;
        this.currency = currency;
    }

    void addAmountOfCurrencyUAH(float addedUAH){
        this.amountOfCurrencyUAH=amountOfCurrencyUAH+addedUAH;
    }

    void addAmountOfCurrencyUSD(float addedUSD){
        this.amountOfCurrencyUSD=amountOfCurrencyUSD+addedUSD;
    }

    void addAmountOfCurrencyEUR(float addedEUR){
        this.amountOfCurrencyEUR=amountOfCurrencyEUR+addedEUR;
    }

    void pullOffAmountOfCurrencyUAH(float pullUAH){                //возможны отрицательные значения, к примеру кредит
        this.amountOfCurrencyUAH=amountOfCurrencyUAH-pullUAH;
    }

    void pullOffAmountOfCurrencyUSD(float pullUSD){
        this.amountOfCurrencyUSD=amountOfCurrencyUAH-pullUSD;
    }

    void pullOffAmountOfCurrencyEUR(float pullEUR){
        this.amountOfCurrencyUAH=amountOfCurrencyEUR-pullEUR;
    }



}

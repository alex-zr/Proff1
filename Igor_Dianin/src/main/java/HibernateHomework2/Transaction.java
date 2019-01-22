package HibernateHomework2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "AllTransactions", query = "SELECT t FROM transaction t"),
        @NamedQuery(name = "Select Transaction where id ?", query = "SELECT t FROM transaction t WHERE id=:id_number")
})
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_transaction")
    private BigDecimal numberTransaction;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_sender")
    private Account accountSender;

    @ManyToOne
    @JoinColumn(name = "account_recipient")
    private Account accountRecipient;


}

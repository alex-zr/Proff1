package HibernateHomework2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Synchronized;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "AllUsers", query = "SELECT u FROM user u"),
        @NamedQuery(name = "Select user where id ?", query = "SELECT t FROM transaction t WHERE id=:id_number")
})
  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",nullable = false, length = 32)
    private String name;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Account>accounts;

    User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }


}

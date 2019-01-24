package HibernateHomework1;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "weight")
    private float weight;
    @Column(name = "discount")
    private int discount;


}

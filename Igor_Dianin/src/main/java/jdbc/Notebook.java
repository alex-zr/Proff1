package jdbc;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @Column (name = "price")
    private int price;
    @Column(name = "isUsed")
    private String isUsed;
    @Column (name = "date")
    private Date date;



}

package allllll.myHiperTask;



import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="laptops")

public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String model;
    private String brand;
    private Integer price;

    @Column(name = "is_used")
    private boolean isUsed;
@Temporal(TemporalType.DATE)
    private Date date;
    //SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
public Laptop(){}

    public Laptop(String model, String brand, Integer price, boolean isUsed,Date date) {
        this.model = model;
        this.brand = brand;
        this.date = date;
        this.isUsed = isUsed;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", isUsed=" + isUsed +
                ", date=" + date +
                '}';
    }
//    static EntityManager em;
//    public void viewLaptops(){
//        Query query = em.createQuery("FROM Laptop c",Laptop.class);
//        List<Laptop> list = (List<Laptop>) query.getResultList();
//
//        for (Laptop c : list)
//            System.out.println(c);
//
//    }
}

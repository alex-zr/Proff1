package ua.kiev.prog;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String model;
    private String brand;
    private BigDecimal price;
    private Date date;
    @Column(name = "is used")
    private boolean isUsed;

    public Notebook() {

    }

    public Notebook(String model, String brand, BigDecimal price, Date date) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.date = date;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String
    toString() {
        return "Notebook{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", isUsed=" + isUsed +
                '}';
    }
}

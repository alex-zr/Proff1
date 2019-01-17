package hibernateTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private String brand;
    private double price;

    @Column(name = "Used")
    private boolean isUsed;

    private LocalDate date;

    public Notebook() {
    }

    public Notebook(String model, String brand, double price, boolean isUsed, LocalDate date) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.isUsed = isUsed;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

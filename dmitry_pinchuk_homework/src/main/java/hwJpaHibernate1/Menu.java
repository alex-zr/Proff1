package hwJpaHibernate1;

import javax.persistence.*;


@Entity
@Table(name = "MenuRest")
//@NamedQueries({
//        @NamedQuery(name = "Menu.findAll", query = "SELECT c FROM Menu"),
//        @NamedQuery(name = "Menu.discount", query = "SELECT c FROM Menu c WHERE c.discount = :discount"),
//        @NamedQuery(name = "Menu.weight", query = "SELECT c FROM Menu c WHERE c.weight <= :weight"),
//        @NamedQuery(name = "Menu.fromTo",query = "SELECT c FROM Menu c where (c.price >= :from) AND (c.price <= :to)")
//
//})
public class Menu {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String dish;
    private double price;
    private double weight;
    private boolean discount;

    public Menu() {
    }

    public Menu(String dish, double price, double weight, boolean discount) {
        this.dish = dish;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dish='" + dish + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}

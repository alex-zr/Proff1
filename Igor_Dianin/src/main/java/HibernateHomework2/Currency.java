package HibernateHomework2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "currency")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course_usd")
    private float courseUSD;

    @Column(name = "course_uah")
    private float courseUAH;

    @Column(name = "course_eur")
    private float courseEUR;

    public Currency(String name, float courseUSD, float courseUAH, float courseEUR) {
        this.name = name;
        this.courseUSD = courseUSD;
        this.courseUAH = courseUAH;
        this.courseEUR = courseEUR;
    }
}

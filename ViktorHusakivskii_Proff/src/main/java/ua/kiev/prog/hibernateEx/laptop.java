package ua.kiev.prog.hibernateEx;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Laptops")
public class laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long id;

	String model;

	String brand;

	String price;

	String isUsed;

	Date date;
	public laptop(String model, String brand,String price,String isUsed,Date date){
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.isUsed = isUsed;
		this.date = date;
	}
}

package ua.kiev.prog.hibernate_HomeWork;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "Menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dish_id")
	Long id;

	@Column(name = "dish_name")
	String name;

	@Column(name = "dish_price")
	int price;

	@Column(name = "dish_weight")
	int weight;

	@Column(name = "dish_discont")
	int discont;

	public Menu(String name, int price, int weight, int discont){
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.discont = discont;
	}
}
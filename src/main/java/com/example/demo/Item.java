package com.example.demo;
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String hotCoffee;
    private String coldCoffee;
    private String pizzaCoffee;
    private Double price; // NEW FIELD

    private Integer hotCoffeeQuantity;
    private Integer coldCoffeeQuantity;
    private Integer pizzaQuantity;

    // Getters and Setters

    // Getters and Setters

    

    public Integer getHotCoffeeQuantity() {
		return hotCoffeeQuantity;
	}

	public void setHotCoffeeQuantity(Integer hotCoffeeQuantity) {
		this.hotCoffeeQuantity = hotCoffeeQuantity;
	}

	public Integer getColdCoffeeQuantity() {
		return coldCoffeeQuantity;
	}

	public void setColdCoffeeQuantity(Integer coldCoffeeQuantity) {
		this.coldCoffeeQuantity = coldCoffeeQuantity;
	}

	public Integer getPizzaQuantity() {
		return pizzaQuantity;
	}

	public void setPizzaQuantity(Integer pizzaQuantity) {
		this.pizzaQuantity = pizzaQuantity;
	}

	// Optional: a method to calculate price
	public void calculatePrice() {
	    int total = 0;

	    if (hotCoffee != null && hotCoffeeQuantity != null) {
	        switch (hotCoffee) {
	            case "Espresso" -> total += 100 * hotCoffeeQuantity;
	            case "Cappuccino" -> total += 120 * hotCoffeeQuantity;
	            case "Latte" -> total += 130 * hotCoffeeQuantity;
	        }
	    }

	    if (coldCoffee != null && coldCoffeeQuantity != null) {
	        switch (coldCoffee) {
	            case "Cold Brew" -> total += 110 * coldCoffeeQuantity;
	            case "Iced Latte" -> total += 140 * coldCoffeeQuantity;
	            case "Frappuccino" -> total += 150 * coldCoffeeQuantity;
	        }
	    }

	    if (pizzaCoffee != null && pizzaQuantity != null) {
	        switch (pizzaCoffee) {
	            case "Chees & corn" -> total += 110 * pizzaQuantity;
	            case "Chees & paneer" -> total += 140 * pizzaQuantity;
	            case "Tandoor" -> total += 150 * pizzaQuantity;
	        }
	    }

	    this.price = (double) total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotCoffee() {
		return hotCoffee;
	}

	public void setHotCoffee(String hotCoffee) {
		this.hotCoffee = hotCoffee;
	}

	public String getColdCoffee() {
		return coldCoffee;
	}

	public void setColdCoffee(String coldCoffee) {
		this.coldCoffee = coldCoffee;
	}

	public String getPizzaCoffee() {
		return pizzaCoffee;
	}

	public void setPizzaCoffee(String pizzaCoffee) {
		this.pizzaCoffee = pizzaCoffee;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Item(long id, String hotCoffee, String coldCoffee, String pizzaCoffee, double price) {
		super();
		this.id = id;
		this.hotCoffee = hotCoffee;
		this.coldCoffee = coldCoffee;
		this.pizzaCoffee = pizzaCoffee;
		this.price = price;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
}

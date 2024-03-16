package RMI.QuanLySanPham.src;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// Thiếu set

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

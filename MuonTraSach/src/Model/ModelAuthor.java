package Model;

import java.io.Serializable;

public class ModelAuthor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private String id, name;
	private int age;
	private String phone;

	public ModelAuthor() {
		super();
	}

	public ModelAuthor(String id) {
		this.id = id;
	}

	public ModelAuthor(String country, String name, int age, String phone) {
		super();
		this.country = country;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public ModelAuthor(String id, String name, int age, String phone, String country) {
		this.country = country;
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

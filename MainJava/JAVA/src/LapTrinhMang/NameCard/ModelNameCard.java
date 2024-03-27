package LapTrinhMang.NameCard;

import java.io.Serializable;

public class ModelNameCard implements Serializable {
	private String name, address, phone, email, picture;
	private static final long serialVersionUID = 1L;

	public ModelNameCard() {
	}

	public ModelNameCard(String name, String address, String phone, String email, String picture) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}

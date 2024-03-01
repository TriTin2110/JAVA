package RMI.Lab3;

import java.io.Serializable;

public class modelCustomer implements Serializable {
	private String name, customerType;
	private int phone;

	public modelCustomer() {
	}

	public modelCustomer(String name, String customerType, int phone) {
		this.name = name;
		this.customerType = customerType;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "modelCustomer [name=" + name + ", customerType=" + customerType + ", phone=" + phone + "]";
	}

}

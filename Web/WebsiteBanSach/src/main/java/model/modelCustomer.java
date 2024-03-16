package model;

import java.sql.Date;

public class modelCustomer {
	private String customerId, userName, userPassword, customerName, gender, address, addressReceive, addressSell,
			email, phoneNumber;
	private Date dateOfBirth;
	private boolean signEmail;

	public modelCustomer(String customerId) {
		this.customerId = customerId;
	}

	public modelCustomer(String customerId, String userName, String userPassword, String customerName, String gender,
			String address, String addressReceive, String addressSell, String email, String phoneNumber,
			Date dateOfBirth, boolean signEmail) {
		this.customerId = customerId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.customerName = customerName;
		this.gender = gender;
		this.address = address;
		this.addressReceive = addressReceive;
		this.addressSell = addressSell;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.signEmail = signEmail;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressReceive() {
		return addressReceive;
	}

	public void setAddressReceive(String addressReceive) {
		this.addressReceive = addressReceive;
	}

	public String getAddressSell() {
		return addressSell;
	}

	public void setAddressSell(String addressSell) {
		this.addressSell = addressSell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isSignEmail() {
		return signEmail;
	}

	public void setSignEmail(boolean signEmail) {
		this.signEmail = signEmail;
	}

	@Override
	public String toString() {
		return "modelCustomer [customerId=" + customerId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", customerName=" + customerName + ", gender=" + gender + ", address=" + address + ", addressReceive="
				+ addressReceive + ", addressSell=" + addressSell + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + ", signEmail=" + signEmail + "]";
	}

}

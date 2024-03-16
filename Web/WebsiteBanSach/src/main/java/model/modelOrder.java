package model;

import java.sql.Date;

public class modelOrder {
	private String orderId, addressBuyer, addressReceive, status, payment, statusPayment, moneyPaid, moneyRemain;
	private modelCustomer customer;
	private Date orderDate, shipDate;

	public modelOrder(String orderId) {
		this.orderId = orderId;
	}

	public modelOrder(String orderId, String addressBuyer, String addressReceive, String status, String payment,
			String statusPayment, String moneyPaid, String moneyRemain, modelCustomer customer, Date orderDate,
			Date shipDate) {
		this.orderId = orderId;
		this.addressBuyer = addressBuyer;
		this.addressReceive = addressReceive;
		this.status = status;
		this.payment = payment;
		this.statusPayment = statusPayment;
		this.moneyPaid = moneyPaid;
		this.moneyRemain = moneyRemain;
		this.customer = customer;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddressBuyer() {
		return addressBuyer;
	}

	public void setAddressBuyer(String addressBuyer) {
		this.addressBuyer = addressBuyer;
	}

	public String getAddressReceive() {
		return addressReceive;
	}

	public void setAddressReceive(String addressReceive) {
		this.addressReceive = addressReceive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

	public String getMoneyPaid() {
		return moneyPaid;
	}

	public void setMoneyPaid(String moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	public String getMoneyRemain() {
		return moneyRemain;
	}

	public void setMoneyRemain(String moneyRemain) {
		this.moneyRemain = moneyRemain;
	}

	public modelCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(modelCustomer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "modelOrder [orderId=" + orderId + ", addressBuyer=" + addressBuyer + ", addressReceive="
				+ addressReceive + ", status=" + status + ", payment=" + payment + ", statusPayment=" + statusPayment
				+ ", moneyPaid=" + moneyPaid + ", moneyRemain=" + moneyRemain + ", customer=" + customer
				+ ", orderDate=" + orderDate + ", shipDate=" + shipDate + "]";
	}

}

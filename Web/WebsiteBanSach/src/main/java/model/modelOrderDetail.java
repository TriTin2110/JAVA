package model;

public class modelOrderDetail {
	private String orderDetailId, bookId;
	private modelOrder order;
	private long coverPrice, discount, sellPrice, VAT, total;
	private int quantity;

	public modelOrderDetail(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public modelOrderDetail(String orderDetailId, String bookId, modelOrder order, long coverPrice, long discount,
			long sellPrice, long vAT, long total, int quantity) {
		this.orderDetailId = orderDetailId;
		this.bookId = bookId;
		this.order = order;
		this.coverPrice = coverPrice;
		this.discount = discount;
		this.sellPrice = sellPrice;
		VAT = vAT;
		this.total = total;
		this.quantity = quantity;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public modelOrder getOrder() {
		return order;
	}

	public void setOrder(modelOrder order) {
		this.order = order;
	}

	public long getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(long coverPrice) {
		this.coverPrice = coverPrice;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(long sellPrice) {
		this.sellPrice = sellPrice;
	}

	public long getVAT() {
		return VAT;
	}

	public void setVAT(long vAT) {
		VAT = vAT;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "modelOrderDetail [orderDetailId=" + orderDetailId + ", bookId=" + bookId + ", order=" + order
				+ ", coverPrice=" + coverPrice + ", discount=" + discount + ", sellPrice=" + sellPrice + ", VAT=" + VAT
				+ ", total=" + total + ", quantity=" + quantity + "]";
	}

}

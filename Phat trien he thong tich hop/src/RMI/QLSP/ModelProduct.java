package RMI.QLSP;

import java.io.Serializable;

public class ModelProduct implements Serializable {
	private String id, productName;
	private long price;

	public ModelProduct() {
	}

	public ModelProduct(String id, String productName, long price) {
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}

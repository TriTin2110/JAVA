package Lab4.model;

public class modelProduct {
//	Prodcut(ProductID, ProductName, Price, CompanyID)
	private String productID, productName, companyID;
	private long price;

	public modelProduct(String productID) {
		this.productID = productID;
	}

	public modelProduct(String productID, String productName, String companyID, long price) {
		this.productID = productID;
		this.productName = productName;
		this.companyID = companyID;
		this.price = price;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "productID=" + productID + ", productName=" + productName + ", companyID=" + companyID + ", price="+ price;
	}

}

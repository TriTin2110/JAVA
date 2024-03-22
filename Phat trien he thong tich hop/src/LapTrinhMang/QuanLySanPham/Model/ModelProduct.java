package LapTrinhMang.QuanLySanPham.Model;

public class ModelProduct extends ModelManageProduct {
	private long price;
	private String idCompany;

	public ModelProduct() {
		super();
	}

	public ModelProduct(String id) {
		super(id);
	}

	public ModelProduct(String id, String name, long price, String idCompany) {
		super(id, name);
		this.price = price;
		this.idCompany = idCompany;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

}

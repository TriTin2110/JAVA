package LapTrinhMang.QuanLySanPham.Model;

public class ModelCompany extends ModelManageProduct {
	private String addressCompany;

	public ModelCompany() {
		super();
	}

	public ModelCompany(String id) {
		super(id);
	}

	public ModelCompany(String id, String name, String addressCompany) {
		super(id, name);
		this.addressCompany = addressCompany;
	}

	public String getAddressCompany() {
		return addressCompany;
	}

	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}

	@Override
	public String toString() {
		return "ModelCompany [addressCompany=" + addressCompany + ", getId()=" + getId() + ", getName()=" + getName()
				+ "]";
	}

}

package LapTrinhMang.QuanLySanPham.Model;

public class ModelManageProduct {
	private String id, name;

	public ModelManageProduct() {
		super();
	}

	public ModelManageProduct(String id) {
		super();
		this.id = id;
	}

	public ModelManageProduct(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}

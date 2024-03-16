package LapTrinhMang.Test;

class ModelKhachHang {
	private int id;
	private String name;

	public ModelKhachHang() {
	}

	public ModelKhachHang(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

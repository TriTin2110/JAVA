package CanBo;

class CanBo {
	protected String name, gioiTinh, diaChi;
	protected int tuoi;

	public CanBo(String name, String gioiTinh, String diaChi, int tuoi) {
		// TODO Auto-generated constructor stub
		this.name = name;
		if (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nữ")) {
			System.out.println("Giới tính không hợp lệ!");
			return;
		} else {
			this.gioiTinh = gioiTinh;
		}
		this.diaChi = diaChi;
		this.tuoi = tuoi;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getGioiTinh() {
		return gioiTinh;
	}

	void setGioiTinh(String gioiTinh) {
		if (gioiTinh != "Nam" && gioiTinh != "Nữ") {
			System.out.println("Giới tính không hợp lệ!");
			return;
		} else {
			this.gioiTinh = gioiTinh;
		}
	}

	String getDiaChi() {
		return diaChi;
	}

	void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	int getTuoi() {
		return tuoi;
	}

	void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
}

package LoaiPhuongTien;

class HangSanXuat {
	private String tenHang, quocGia;

	public HangSanXuat(String tenHang, String quocGia) {
		this.tenHang = tenHang;
		this.quocGia = quocGia;
	}

	String getTenHang() {
		return tenHang;
	}

	void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	String getQuocGia() {
		return quocGia;
	}

	void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

}

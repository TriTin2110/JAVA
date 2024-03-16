package Enum;

enum Mua {
	Mùa_Xuân(4, "Mát"), Mùa_Hè(4, "Nóng"), Mùa_Thu(2, "Mát"), Mùa_Đông(2, "Lạnh");

	private int thang;
	private String thoiTiet;

	private Mua(int thang, String thoiTiet) {
		this.thang = thang;
		this.thoiTiet = thoiTiet;
	}

	int getThang() {
		return thang;
	}

	void setThang(int thang) {
		this.thang = thang;
	}

	String getThoiTiet() {
		return thoiTiet;
	}

	void setThoiTiet(String thoiTiet) {
		this.thoiTiet = thoiTiet;
	}

}

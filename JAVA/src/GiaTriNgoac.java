
enum GiaTriNgoac {
	ngoacTronMo(0), ngoacTronDong(0), ngoacNhonMo(0), ngoacNhonDong(0), ngoacVuongMo(0), ngoacVuongDong(0);

	private int giaTri;

	GiaTriNgoac(int i) {
		// TODO Auto-generated constructor stub
		this.giaTri = i;
	}

	int getGiaTri() {
		return giaTri;
	}

	void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}

}

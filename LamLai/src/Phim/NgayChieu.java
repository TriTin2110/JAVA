package Phim;

class NgayChieu {
	private int ngay;
	private int thang;
	private int nam;

	public NgayChieu(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	int getNgay() {
		return ngay;
	}

	void setNgay(int ngay) {
		this.ngay = ngay;
	}

	int getThang() {
		return thang;
	}

	void setThang(int thang) {
		this.thang = thang;
	}

	int getNam() {
		return nam;
	}

	void setNam(int nam) {
		this.nam = nam;
	}

	@Override
	public String toString() {
		return ngay + "/" + thang + "/" + nam;
	}

}

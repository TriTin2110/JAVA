package TaoFile;

class hocSinh {
	private ngaySinh ngay;
	private int maHocSinh;
	private String tenHocSinh;

	public hocSinh(int maHocSinh, String tenHocSinh, ngaySinh ngay) {
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "\nMã số của sinh viên là: " + this.maHocSinh + "\nTên của sinh viên là: " + this.tenHocSinh
				+ "\nNgày sinh của sinh viên là: " + this.ngay;
	}

}

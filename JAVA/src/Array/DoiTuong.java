package Array;

class DoiTuong implements Comparable<DoiTuong> {
	private String name;
	private double diem;
	private int MSSV;

	public DoiTuong(String name, double diem, int mSSV) {
		this.name = name;
		this.diem = diem;
		this.MSSV = mSSV;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getDiem() {
		return diem;
	}

	void setDiem(double diem) {
		this.diem = diem;
	}

	int getMSSV() {
		return MSSV;
	}

	void setMSSV(int mSSV) {
		MSSV = mSSV;
	}

	// Kiểm tra xem tên có khoảng trắng hay ko
	// Nếu có thì sẽ lấy ten = từ khoảng trắng cuối cùng +1
	String layTen() {
		String ten = "";
		if (name.indexOf(" ") > 0) {
			ten = name.substring(name.lastIndexOf(" ") + 1);
		}
		return ten;
	}

	@Override
	public int compareTo(DoiTuong o) {
		// TODO Auto-generated method stub
		return this.MSSV - o.MSSV;
	}

	public int compareToName(DoiTuong o) {
		// TODO Auto-generated method stub
		return layTen().compareTo(o.layTen());
	}

	public double compareToMark(DoiTuong o) {
		// TODO Auto-generated method stub
		return diem - o.diem;
	}
}
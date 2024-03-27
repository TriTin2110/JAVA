package DanhSachXe;

class Xe {
	private String maXe, chuXe, moTa;
	private long giaXe, giaThue;
	private int dungTich;

	public Xe(String maXe, String chuXe, String moTa, long giaXe, int dungTich) {
		this.maXe = maXe;
		this.chuXe = chuXe;
		this.moTa = moTa;
		this.giaXe = giaXe;
		this.dungTich = dungTich;
	}

	String getMaXe() {
		return maXe;
	}

	void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	String getChuXe() {
		return chuXe;
	}

	void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}

	String getMoTa() {
		return moTa;
	}

	void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	long getGiaXe() {
		return giaXe;
	}

	long getGiaThue() {
		return giaThue;
	}

	void setGiaThue(long giaThue) {
		this.giaThue = giaThue;
	}

	void setGiaXe(long giaXe) {
		this.giaXe = giaXe;
	}

	int getDungTich() {
		return dungTich;
	}

	void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", chuXe=" + chuXe + ", moTa=" + moTa + ", giaXe=" + giaXe + ", giaThue=" + giaThue
				+ ", dungTich=" + dungTich + "]";
	}

}

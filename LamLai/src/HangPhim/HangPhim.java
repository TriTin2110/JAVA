package HangPhim;

public class HangPhim {
	private String tenHangPhim, quocGia;

	public HangPhim(String tenHangPhim, String quocGia) {
		this.tenHangPhim = tenHangPhim;
		this.quocGia = quocGia;
	}

	String getTenHangPhim() {
		return tenHangPhim;
	}

	void setTenHangPhim(String tenHangPhim) {
		this.tenHangPhim = tenHangPhim;
	}

	String getQuocGia() {
		return quocGia;
	}

	void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

}

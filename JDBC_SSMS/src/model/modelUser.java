package model;

public class modelUser {
	String taiKhoan, matKhau;

	public modelUser(String tk) {
		this.taiKhoan = tk;
	}

	public modelUser(String taiKhoan, String matKhau) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "modelUser [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + "]";
	}

}

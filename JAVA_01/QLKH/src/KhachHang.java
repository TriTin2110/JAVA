
public class KhachHang {
	 String hotenKH;
	 String masoKH;
	 long taiKhoan;
	 String phanLoai;
	 public KhachHang() {
		this.hotenKH = "";
		this.masoKH = "";
		this.taiKhoan = 0;
		this.phanLoai = "";
	}
	 public KhachHang(String ht, String ms, long tk) {
		this.hotenKH = ht;
		this.masoKH = ms;
		this.taiKhoan = tk;
		if(tk>=1000000000)
			this.phanLoai = "VIP";
		else if(tk>=100000000)
			this.phanLoai = "Tiem nang";
		else {
			this.phanLoai = "Pho thong";
		}
	}
	 public String getHoTen() {
		return this.hotenKH;
	}
	 public String getMaSo() {
		return this.masoKH;
	}
	 public long getTaiKhoan() {
			return this.taiKhoan;
	}
	 public String getPhanLoai() {
		return this.phanLoai;
	}
}

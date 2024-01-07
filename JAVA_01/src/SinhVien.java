
public class SinhVien {
	String hoten;
	String maso;
	double diem;
	String ketqua;
	public SinhVien() {
		this.hoten = "";
		this.maso = "";
		this.diem = 0;
		this.ketqua = "";
	}
	public SinhVien(String ht, String mssv, double d) {
		this.hoten = ht;
		this.maso = mssv;
		this.diem = d;
		if(d>5)
			this.ketqua = "Dau";
		else {
			this.ketqua = "Rot";
		}
	}
	public String setHoTen(String ht) {
		return this.hoten = ht;
	}
	public String setMaSo(String mssv) {
		return this.maso = mssv;
	}
	public String setKetQua(Double d) {
		this.diem = d;
		if(d>5)
			return this.ketqua = "Dau";
		else {
			return this.ketqua = "Rot";
		}
	}
	public String getTen()
	{
		String chuoi[] = this.hoten.split("\\s");
		return chuoi[chuoi.length-1];
	}
	public String getHoTen() {
		return this.hoten;
	}
	public String getMaSo() {
		return this.maso;
	}
	public double getDiem() {
		return this.diem;
	}
	public String getKetQua() {
		return this.ketqua;
	}
}

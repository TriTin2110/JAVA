import java.io.Serializable;

public class SinhVien implements Serializable {
	String hoten;
	String maso;
	double diem;
	String ketqua;
	public SinhVien()  {
		this.hoten = "";
		this.maso = "";
		this.diem = 0;
		this.ketqua = "";
	}
	public SinhVien(String ht, String ms, double d) {
		this.hoten = ht;
		this.maso = ms;
		this.diem = d;
		if(d>5)
			this.ketqua = "Dau";
		else {
			this.ketqua = "Rot";
		}
	}
	public String setHoTen(String ht) {
		return this.hoten ;
	}
	public String setMaSo(String ms) {
		return this.maso = ms;
	}
	public String setKetQua(Double d) {
		this.diem = d;
		if(d>5)
			return this.ketqua = "Dau";
		else {
			return this.ketqua = "Rot";
		}
	}
	public String getHoTen() {
		return this.hoten;
	}
	public String getTen() {
		String chuoi[] = this.hoten.split("\\s");
		return chuoi[chuoi.length-1];
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

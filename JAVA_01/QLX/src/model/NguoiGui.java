package model;

public class NguoiGui {
	private String hoTen;
	private String bienSo;
	public NguoiGui(String ht, String bs)
	{
		this.hoTen = ht;
		this.bienSo = bs;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	
}

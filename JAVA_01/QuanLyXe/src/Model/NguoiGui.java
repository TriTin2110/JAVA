package Model;

public class NguoiGui {
	private String hoTen;
	private String bienSo;
	public NguoiGui(String hoTen, String bienSo) {
		this.hoTen = hoTen;
		this.bienSo = bienSo;
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

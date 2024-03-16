package model;

public class modelSach {
	private int maSach, namXuatBan;
	private String tenSach;
	private float giaSach;

	public modelSach(int maSach) {
		this.maSach = maSach;
	}

	public modelSach(int maSach, int namXuatBan, String tenSach, float giaSach) {
		this.maSach = maSach;
		this.namXuatBan = namXuatBan;
		this.tenSach = tenSach;
		this.giaSach = giaSach;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public float getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(float giaSach) {
		this.giaSach = giaSach;
	}

	@Override
	public String toString() {
		return "modelSach [maSach=" + maSach + ", namXuatBan=" + namXuatBan + ", tenSach=" + tenSach + ", giaSach="
				+ giaSach + "]";
	}

}

package model;

import java.sql.Date;

public class khachHang {
	private int maKhachHang;
	private String tenKhachHang;
	private Date ngayMuaSach;

	public khachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public khachHang(int maKhachHang, String tenKhachHang, Date ngayMuaSach) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngayMuaSach = ngayMuaSach;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getNgayMuaSach() {
		return ngayMuaSach;
	}

	public void setNgayMuaSach(Date ngayMuaSach) {
		this.ngayMuaSach = ngayMuaSach;
	}

	@Override
	public String toString() {
		return "khachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ngayMuaSach="
				+ ngayMuaSach + "]";
	}

}

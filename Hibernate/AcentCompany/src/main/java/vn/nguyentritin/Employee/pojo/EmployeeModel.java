package vn.nguyentritin.Employee.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Nationalized
	private String tenNhanVien;
	private Date ngaySinh;
	private int luong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhongBan", nullable = false) // khóa ngoại lệ của Employee là maPhongBan tham chiếu đến
														// khóa chính là maPhongBan của Department
	private Department phongBan;

	public EmployeeModel() {
	}

	public EmployeeModel(int id) {
		this.id = id;
	}

	public EmployeeModel(String tenNhanVien, Date ngaySinh, int luong) {
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.luong = luong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public Department getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(Department phongBan) {
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh + ", luong="
				+ luong + "]";
	}

}

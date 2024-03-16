package vn.nguyentritin.Employee.pojo;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Nationalized;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhongBan;
	@Nationalized
	private String tenPhongBan;
	@Nationalized
	private String moTaPhongBan;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phongBan") // Ánh xạ đến đối tượng Deparment trong EmployeeModel
	private Set<EmployeeModel> listEmployee = new TreeSet<>();

	public Department() {
	}

	public Department(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public Department(String tenPhongBan, String moTaPhongBan) {
		this.tenPhongBan = tenPhongBan;
		this.moTaPhongBan = moTaPhongBan;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public String getMoTaPhongBan() {
		return moTaPhongBan;
	}

	public void setMoTaPhongBan(String moTaPhongBan) {
		this.moTaPhongBan = moTaPhongBan;
	}

	public Set<EmployeeModel> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(Set<EmployeeModel> listEmployee) {
		this.listEmployee = listEmployee;
	}

}

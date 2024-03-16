package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class modelTaiKhoan {
	@Id
	private String taiKhoan;
	private String matKhau;
	@OneToMany(mappedBy = "taiKhoan")
	private List<modelGhiChu> modelGhiChu;
	@OneToMany(mappedBy = "modelTaiKhoan")
	private List<modelFile> modelFiles;

	public modelTaiKhoan(String taiKhoan, String matKhau) {
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	// Bắt buộc phải có default constructor
	public modelTaiKhoan() {
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

	public List<modelGhiChu> getModelGhiChu() {
		return modelGhiChu;
	}

	public void setModelGhiChu(List<modelGhiChu> modelGhiChu) {
		this.modelGhiChu = modelGhiChu;
	}

}

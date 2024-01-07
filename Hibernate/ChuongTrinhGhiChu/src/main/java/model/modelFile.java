package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Nationalized;

@Entity
public class modelFile implements Serializable {
	@Id
	private String duongDan;
	@Nationalized
	private String trangThai;
	private Date ngayTao, ngayXoa, ngayKhoiPhuc;
	@OneToOne
	@JoinColumn(name = "id_GhiChu")
	modelGhiChu modelGhiChu;

	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	modelTaiKhoan modelTaiKhoan;

	public modelFile() {
	}

	public String getDuongDan() {
		return duongDan;
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayXoa() {
		return ngayXoa;
	}

	public void setNgayXoa(Date ngayXoa) {
		this.ngayXoa = ngayXoa;
	}

	public Date getNgayKhoiPhuc() {
		return ngayKhoiPhuc;
	}

	public void setNgayKhoiPhuc(Date ngayKhoiPhuc) {
		this.ngayKhoiPhuc = ngayKhoiPhuc;
	}

	public modelGhiChu getModelGhiChu() {
		return modelGhiChu;
	}

	public void setModelGhiChu(modelGhiChu modelGhiChu) {
		this.modelGhiChu = modelGhiChu;
	}

	public modelTaiKhoan getModelTaiKhoan() {
		return modelTaiKhoan;
	}

	public void setModelTaiKhoan(modelTaiKhoan modelTaiKhoan) {
		this.modelTaiKhoan = modelTaiKhoan;
	}

}

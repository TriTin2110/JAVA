package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Nationalized;

@Entity
public class modelGhiChu implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	@Nationalized
	private String tieuDe;
	@Nationalized
	@Column(name = "noiDung", columnDefinition = "ntext") // Cài đặt kích cỡ cho cột nội dung = nvarchar(max)
	private String noiDung;
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private modelTaiKhoan taiKhoan;
	private boolean chayLanDau;
	@OneToOne(mappedBy = "modelGhiChu")
	private modelFile modelFile;

	public modelGhiChu() {
	}

	public modelGhiChu(String tieuDe, String noiDung) {
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public modelTaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(modelTaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public boolean isChayLanDau() {
		return chayLanDau;
	}

	public void setChayLanDau(boolean chayLanDau) {
		this.chayLanDau = chayLanDau;
	}

}

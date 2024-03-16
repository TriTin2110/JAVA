package GiaoDien.MayTinhBoTui;

public class ModelMayTinhBoTui {
	private double giaTri1, giaTri2, ketQua;

	public ModelMayTinhBoTui() {
	}

	double getGiaTri1() {
		return giaTri1;
	}

	void setGiaTri1(double giaTri1) {
		this.giaTri1 = giaTri1;
	}

	double getGiaTri2() {
		return giaTri2;
	}

	void setGiaTri2(double giaTri2) {
		this.giaTri2 = giaTri2;
	}

	double getKetQua() {
		return ketQua;
	}

	void setKetQua(double ketQua) {
		this.ketQua = ketQua;
	}

	double phepCong() {
		ketQua = this.giaTri1 + this.giaTri2;
		return ketQua;
	}

	double phepTru() {
		ketQua = this.giaTri1 - this.giaTri2;
		return ketQua;
	}

	double phepNhan() {
		ketQua = this.giaTri1 * this.giaTri2;
		return ketQua;
	}

	double phepChia() {
		ketQua = this.giaTri1 / this.giaTri2;
		return ketQua;
	}

	double tinhLuyThua() {
		ketQua = Math.pow(this.giaTri1, this.giaTri2);
		return ketQua;
	}

	double tinhCanBac2() {
		ketQua = Math.sqrt(giaTri2);
		return ketQua;
	}

	double tinhCanBac3() {
		ketQua = Math.cbrt(giaTri2);
		return ketQua;
	}

}

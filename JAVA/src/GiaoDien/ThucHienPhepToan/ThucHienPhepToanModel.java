package GiaoDien.ThucHienPhepToan;

public class ThucHienPhepToanModel {
	private double giaTri1, giaTri2, ketQua;

	public ThucHienPhepToanModel() {
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
		return this.giaTri1 + this.giaTri2;
	}

	double phepTru() {
		return this.giaTri1 - this.giaTri2;
	}

	double phepNhan() {
		return this.giaTri1 * this.giaTri2;
	}

	double phepChia() {
		return this.giaTri1 / this.giaTri2;
	}

	double tichPhan() {
		return Math.pow(giaTri1, giaTri2);
	}

	double chiaLayDu() {
		return this.giaTri1 % this.giaTri2;
	}
}

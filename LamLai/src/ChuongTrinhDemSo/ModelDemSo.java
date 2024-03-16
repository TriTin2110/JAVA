package ChuongTrinhDemSo;

class ModelDemSo {
	private char giaTri;

	public ModelDemSo() {
		this.giaTri = 'A';
	}

	char getGiaTri() {
		return giaTri;
	}

	void setGiaTri(char giaTri) {
		this.giaTri = giaTri;
	}

	void tangGiaTri() {
		this.giaTri++;
	}

	void giamGiaTri() {
		this.giaTri--;
	}

	void resetGiaTri() {
		this.giaTri = 'A';
	}
}

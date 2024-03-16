package ChuonTrinhDemSo;

class ModelDemSo {
	private int giaTri = 0;

	public ModelDemSo() {
	}

	int getGiaTri() {
		return giaTri;
	}

	void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}

	void tangGiaTri() {
		this.giaTri++;
	}

	void giamGiaTri() {
		this.giaTri--;
	}

	void resetGiaTri() {
		this.giaTri = 0;
	}
}

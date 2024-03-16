package GiaoDien.XuLySuKienChuot;

class ModelXuLySuKienChuot {
	private int x, y, soLanNhapChuot = 0;
	private String daVao = "False";

	public ModelXuLySuKienChuot() {
	}

	int getX() {
		return x;
	}

	void setX(int x) {
		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) {
		this.y = y;
	}

	String getDaVao() {
		return daVao;
	}

	void setDaVao(String daVao) {
		this.daVao = daVao;
	}

	int getSoLanNhapChuot() {
		return soLanNhapChuot;
	}

	int setSoLanNhapChuot() {
		return this.soLanNhapChuot++;
	}

}

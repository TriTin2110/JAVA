package GiaoDien.JcomboBoxVaJlist;

import java.util.StringTokenizer;

class ModelBox {
	private String monChinh, monPhu;
	private double tongTienMonChinh, tongTienMonPhu;

	public ModelBox() {
		this.monChinh = "";
		this.monPhu = "";
		this.tongTienMonChinh = 0;
		this.tongTienMonPhu = 0;
	}

	String getMonChinh() {
		return monChinh;
	}

	void setMonChinh(String monChinh) {
		this.monChinh = monChinh;
	}

	String getMonPhu() {
		return monPhu;
	}

	void setMonPhu(String monPhu) {
		this.monPhu = monPhu;
	}

	double getTongTienMonChinh() {
		return tongTienMonChinh;
	}

	void setTongTienMonChinh(double tongTienMonChinh) {
		this.tongTienMonChinh = tongTienMonChinh;
	}

	double getTongTienMonPhu() {
		return tongTienMonPhu;
	}

	void setTongTienMonPhu(double tongTienMonPhu) {
		this.tongTienMonPhu = tongTienMonPhu;
	}

	double tinhTongTienMonChinh() {
		switch (this.monChinh) {
		case "Cơm":
			this.tongTienMonChinh = 25000;
			break;
		case "Phở":
			this.tongTienMonChinh = 30000;
			break;
		case "Cháo":
			this.tongTienMonChinh = 20000;
			break;
		}
		return this.tongTienMonChinh;
	}

	double tinhTongTienMonPhu() {
		tongTienMonPhu = 0;
		StringTokenizer monPhu = new StringTokenizer(this.getMonPhu(), ";");
		while (monPhu.hasMoreTokens()) {
			String monAnPhu = monPhu.nextToken();
			monAnPhu.trim();
			switch (monAnPhu) {
			case "Coca":
				this.tongTienMonPhu += 15000;
				break;
			case "Nước suối":
				this.tongTienMonPhu += 10000;
				break;
			case "Canh rong biển":
				this.tongTienMonPhu += 20000;
				break;
			}
		}
		return this.tongTienMonPhu;
	}
}

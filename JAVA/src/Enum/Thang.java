package Enum;

enum Thang {
	January(31), February(29), March(31), April(30), May(31), June(30), July(31), Auggust(31), September(30),
	October(31), November(30), December(31);

	private int ngay;

	private Thang(int ngay) {
		this.ngay = ngay;
	}

	int getNgay() {
		return ngay;
	}

	void setNgay(int ngay) {
		this.ngay = ngay;
	}

}

public class VND {
	private double tien;

	public VND(double t) {
		this.tien = t;
	}

	public String xuLyTienTe() {
		long tienConverted = (long) this.tien * 1000;
		String tienSauDoi = "";
		String KQ = "";
		while (tienConverted / 1000 != 0) {
			if (tienSauDoi == "") {
				if ((tienConverted % 1000) == 0) {
					tienSauDoi = "000" + tienSauDoi;
				} else if ((tienConverted % 1000) >= 1 && (tienConverted % 1000) <= 9) {
					tienSauDoi = "00" + (tienConverted % 1000) + tienSauDoi;
				} else if ((tienConverted % 1000) >= 10 && (tienConverted % 1000) <= 99) {
					tienSauDoi = "0" + (tienConverted % 1000) + tienSauDoi;
				} else {
					tienSauDoi = (tienConverted % 1000) + tienSauDoi;
				}
			} else {
				if ((tienConverted % 1000) == 0) {
					tienSauDoi = "000" + "." + tienSauDoi;
				} else if ((tienConverted % 1000) >= 1 && (tienConverted % 1000) <= 9) {
					tienSauDoi = "00" + (tienConverted % 1000) + "." + tienSauDoi;
				} else if ((tienConverted % 1000) >= 10 && (tienConverted % 1000) <= 99) {
					tienSauDoi = "0" + (tienConverted % 1000) + "." + tienSauDoi;
				} else {
					tienSauDoi = (tienConverted % 1000) + "." + tienSauDoi;
				}

			}
			tienConverted /= 1000;
		}
		KQ = tienConverted + "." + tienSauDoi + "VNĐ";
		return KQ;
	}
}

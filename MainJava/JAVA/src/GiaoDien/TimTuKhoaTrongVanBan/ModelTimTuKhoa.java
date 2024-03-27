package GiaoDien.TimTuKhoaTrongVanBan;

public class ModelTimTuKhoa {
	private String vanBan, tuKhoa, ketQua;

	public ModelTimTuKhoa() {
		this.vanBan = "";
		this.tuKhoa = "";
		this.ketQua = "";
	}

	String getVanBan() {
		return vanBan;
	}

	void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}

	String getTuKhoa() {
		return tuKhoa;
	}

	void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	String getKetQua() {
		return ketQua;
	}

	void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	String timTuKhoa() {
		int dem = 0;
		boolean timThay = true;
		int viTri = 0;
		while (true) {
			int chuoi = this.vanBan.indexOf(this.tuKhoa, viTri);
			if (chuoi == -1) {
				break;
			} else {
				dem++;
				viTri = chuoi + 1;
			}
		}
		return "Từ khóa \"" + this.tuKhoa + "\" có " + dem + " lần xuất hiện trong văn bản";
	}
}

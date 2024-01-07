
public class EurVaViet {
	private double tienViet;
	private double Eur;

	// Đổi tiền Việt sang Eur
	public void VietSangEur(double tienViet) {
		this.tienViet = tienViet;
	}

	public double doiTienVietSangEur() {
		this.Eur = this.tienViet / 26.17121;
		return (this.Eur);
	}

	// Đổi tiền Eur sang tiền Việt
	public void EurSangViet(double eur) {
		this.Eur = eur;
	}

	public double doiEurSangTienViet() {
		this.tienViet = this.Eur * 26.17121;
		return (long) Math.round(this.tienViet);
	}
}

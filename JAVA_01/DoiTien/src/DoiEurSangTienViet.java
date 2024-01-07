
public class DoiEurSangTienViet {
	private double Eur;
	private double tienViet;

	public DoiEurSangTienViet(double eur) {
		this.Eur = eur;
	}

	public double doiEurSangTienViet() {
		tienViet = this.Eur * 26.130;
		return (long) Math.round(tienViet);
	}
}

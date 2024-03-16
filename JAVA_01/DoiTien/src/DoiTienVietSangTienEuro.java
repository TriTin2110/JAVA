
public class DoiTienVietSangTienEuro {
	private double tienViet;
	private double tienEuro;

	public DoiTienVietSangTienEuro(double tienViet) {
		this.tienViet = tienViet;
	}

	public double doiTienVietSangTienEuro() {
		tienEuro = this.tienViet / 26.130;
		return (long) Math.round(tienEuro);
	}
}

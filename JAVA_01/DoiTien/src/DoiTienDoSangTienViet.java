
public class DoiTienDoSangTienViet {
	private double tienDo;
	private double tienViet;

	public DoiTienDoSangTienViet(double td) {
		this.tienDo = td;
	}

	public double doiTien() {
		this.tienViet = this.tienDo * 23.725;
		return Math.round(this.tienViet);
	}
}

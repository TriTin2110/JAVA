
public class TienDoVaTienViet {
	private double tienViet;
	private double tienDo;
	private int option;

	public TienDoVaTienViet(int option) {
		this.option = option;
	}

	public void name(int option, double tienViet, double tienDo) {
		if (option == 1) {
			setTienViet(tienViet);
		} else {
			setTienDo(tienDo);
		}
	}

	public void setTienViet(double tienViet) {
		this.tienViet = tienViet;
	}

	public void setTienDo(double tienDo) {
		this.tienDo = tienDo;
	}
}

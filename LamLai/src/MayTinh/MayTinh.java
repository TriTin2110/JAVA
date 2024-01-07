package MayTinh;

class MayTinh implements MayTinhInterFace, SapXep {
	private double a, b;

	public MayTinh(double a, double b) {
		this.a = a;
		this.b = b;
	}

	double getA() {
		return a;
	}

	void setA(double a) {
		this.a = a;
	}

	double getB() {
		return b;
	}

	void setB(double b) {
		this.b = b;
	}

	@Override
	public double[] sapXepTang() {
		// TODO Auto-generated method stub
		double[] mang = new double[2];
		mang[0] = a;
		mang[1] = b;
		if (a > b) {
			mang[0] = hoanDoi(mang[1], mang[1] = mang[0]);
		}
		return mang;
	}

	@Override
	public double[] sapXepGiam() {
		// TODO Auto-generated method stub
		double[] mang = new double[2];
		mang[0] = a;
		mang[1] = b;
		if (a < b) {
			mang[0] = hoanDoi(mang[1], mang[1] = mang[0]);
		}
		return mang;
	}

	public double hoanDoi(double a, double b) {
		return a;
	}

	@Override
	public double tinhTong() {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public double tinhHieu() {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double tinhTich() {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double tinhThuong() {
		// TODO Auto-generated method stub
		return a / b;
	}

}

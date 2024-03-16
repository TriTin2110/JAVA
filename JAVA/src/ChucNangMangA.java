
class ChucNangMangA {
	private int[] mang;

	public ChucNangMangA(int[] mang) {
		// TODO Auto-generated constructor stub
		this.mang = mang;
	}

	void timPhanTuLonNhatVaLonThuHaiTrongMang() {
		int phanTuLonNhat = 0;
		int phanTuLonThuHai = 0;
		for (int i = 0; i < mang.length; i++) {
			phanTuLonNhat = (phanTuLonNhat < mang[i]) ? mang[i] : phanTuLonNhat;
		}
		for (int i = 0; i < mang.length; i++) {
			phanTuLonThuHai = (phanTuLonThuHai < mang[i] && mang[i] < phanTuLonNhat) ? mang[i] : phanTuLonThuHai;
		}
		System.out.println("Phần tử lớn NHẤT là: " + phanTuLonNhat);
		System.out.println("Phần tử lớn thứ HAI là: " + phanTuLonThuHai);
	}

	void SapXepMangTangDan() {
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				mang[i] = (mang[i] > mang[j]) ? hoanDoi(mang[j], mang[j] = mang[i]) : mang[i];
			}
		}
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}

	int hoanDoi(int a, int b) {
		return a;
	}
}

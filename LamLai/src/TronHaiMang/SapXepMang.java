package TronHaiMang;

class SapXepMang {
	void sapXepBanDau(int[] mang) {
		XuatMang xuat = new XuatMang();
		xuat.xuatMangBanDau(mang);
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[i] > mang[j]) {
					mang[i] = hoanDoi(mang[j], mang[j] = mang[i]);
				}
			}
		}
		System.out.print("\nSau:\t");
		xuat.XuatMangSauKhiSapXep(mang);
	}

	static int hoanDoi(int a, int b) {
		return a;
	}
}

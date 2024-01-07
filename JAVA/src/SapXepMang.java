
class SapXepMang {
	int[] sapXepMang(int[] mang) {
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[i] > mang[j]) {
					mang[i] = hoanDoi(mang[j], mang[j] = mang[i]);
				}
			}
		}
		return mang;
	}

	void sapXepMangCuoi(int[] mang1, int[] mang2) {
		int[] mang3 = new int[mang1.length + mang2.length];
		System.arraycopy(sapXepMang(mang1), 0, mang3, 0, sapXepMang(mang1).length);
		System.arraycopy(sapXepMang(mang2), 0, mang3, sapXepMang(mang1).length, sapXepMang(mang2).length);
		sapXepMang(mang3);
		for (int i : mang3) {
			System.out.println(i);
		}
	}

	int hoanDoi(int a, int b) {
		return a;
	}
}

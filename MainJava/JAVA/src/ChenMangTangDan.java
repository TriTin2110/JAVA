class ChenMangTangDan {
	public static void main(String[] args) {

		int[] mang1 = { 3, 2, 4 };
		int[] mang2 = { 4, 1, 3 };
		int[] mang = new int[mang1.length + mang2.length];
		for (int i = 0; i < mang.length; i++) {
			if (i < mang1.length) {
				mang[i] = mang1[i];
			} else {
				for (int j = 0; j < mang2.length; j++) {
					mang[i] = mang2[j];
					i++;
				}
				break;
			}
		}
		sapXep(mang);
		for (int i : mang) {
			System.out.println(i);
		}

	}

	static void sapXep(int[] mang) {
		for (int k = 0; k < mang.length - 1; k++) {
			for (int k2 = k + 1; k2 < mang.length; k2++) {
				if (mang[k2] < mang[k]) {
					mang[k2] = hoanDoi(mang[k], mang[k] = mang[k2]);
				}
			}
		}
	}

	static int hoanDoi(int a, int b) {
		return a;
	}
}

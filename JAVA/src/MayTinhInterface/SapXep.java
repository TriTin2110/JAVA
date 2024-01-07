package MayTinhInterface;

class SapXep implements SapXepInterface {

	@Override
	public void sapXepTangDan(int[] mang) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[i] > mang[j]) {
					mang[i] = hoanDoi(mang[j], mang[j] = mang[i]);
				}
			}
		}
		for (int i : mang) {
			System.out.print(i + " ");
		}
	}

	@Override
	public void sapXepGiamDan(int[] mang) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[i] < mang[j]) {
					mang[i] = hoanDoi(mang[j], mang[j] = mang[i]);
				}
			}
		}
		for (int i : mang) {
			System.out.print(i + " ");
		}
	}

	int hoanDoi(int a, int b) {
		return a;
	}
}

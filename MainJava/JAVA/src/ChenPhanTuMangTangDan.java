import java.util.Scanner;

class ChenPhanTuMangTangDan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử có trong mảng: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng phần tử của mảng không hợp lệ!");
			sc.close();
			return;
		}
		int[] mang = new int[n];
		for (int i = 0; i < mang.length; i++) {
			try {
				System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
				mang[i] = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử không hợp lệ!");
				sc.close();
				return;
			}
		}
		outPut(mang);
		sc.close();
	}

	static void outPut(int[] mang) {
		Scanner sc = new Scanner(System.in);
		int soMoi;
		try {
			System.out.println("Hãy nhập giá trị của phần tử thứ " + (mang.length + 1) + ": ");
			soMoi = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của phần tử không hợp lệ!");
			sc.close();
			return;
		}
		sapXep(mang, soMoi);
		for (int i : sapXep(mang, soMoi)) {
			System.out.println(i);
		}
		sc.close();
	}

	static int[] sapXep(int[] mang, int soMoi) {
		int[] mang2 = new int[mang.length + 1];
		for (int i = 0; i < mang.length; i++) {
			mang2[i] = mang[i];
		}
		mang2[mang.length] = soMoi;
		for (int i = 0; i < mang2.length - 1; i++) {
			for (int j = i + 1; j < mang2.length; j++) {
				if (mang2[i] > mang2[j]) {
					mang2[i] = hoanDoi(mang2[j], mang2[j] = mang2[i]);
				}
			}
		}
		return mang2;
	}

	static int hoanDoi(int a, int b) {
		return a;
	}
}

package CacThuatToanSapXep;

import java.util.Scanner;

class SapXepNoiBot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử trong mảng: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng của phần tử không hợp lệ!");
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
				System.out.println("Giá trị của phần tử thứ " + (i + 1) + " không hợp lệ!");
				sc.close();
				return;
			}
		}
		outPut(mang);
		sc.close();
	}

	// So sánh từng cặp bắt đầu từ cuối mảng lên đầu mảng
	static void outPut(int[] mang) {
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = mang.length - 1; j > i; j--) {
				if (mang[j] < mang[j - 1]) {
					mang[j] = hoanDoi(mang[j - 1], mang[j - 1] = mang[j]);
				}
			}
		}
		for (int i : mang) {
			System.out.print(i + "\t");
		}
	}

	static int hoanDoi(int a, int b) {
		return a;
	}
}

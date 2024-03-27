package CacThuatToanSapXep;

import java.util.Scanner;

class SapXepChon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử: ");
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

	// Chọn phần tử đầu của mảng và so sánh vs các phần tử sau
	// Nếu phần tử đầu lớn hơn thì sẽ tiến hành đổi chỗ chúng
	static void outPut(int[] mang) {
		for (int i = 0; i < mang.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[j] < mang[min]) {
					mang[min] = hoanDoi(mang[j], mang[j] = mang[min]);
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

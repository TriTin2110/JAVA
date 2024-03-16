

import java.util.Scanner;

class TinhSoTrungBinhCongTrongMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int doDaiMang = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng phần tử có trong mảng: ");
					doDaiMang = sc.nextInt();
					check = true;
				} while (doDaiMang < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng phần tử trong mảng không hợp lệ!");
				check = false;
			}
			System.out.println();
			sc.nextLine();
		} while (!check);

		int[] mang = new int[doDaiMang];
		for (int i = 0; i < mang.length; i++) {
			do {
				try {
					do {
						System.out.println("Hãy nhập giá trị phần tử thứ " + (i + 1) + ": ");
						mang[i] = sc.nextInt();
						check = true;
					} while (doDaiMang < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị phần tử không hợp lệ!");
					check = false;
				}
				System.out.println();
				sc.nextLine();
			} while (!check);
		}
		output(mang);
		sc.close();
	}

	static void output(int[] mang) {
		int tong = 0;
		for (int i = 0; i < mang.length; i++) {
			tong += mang[i];
		}
		System.out.println("Tổng của các phần tử có trong mảng là: " + tong);
	}
}

package MaTran;

import java.util.Scanner;

class MainMaTran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row = 0, column = 0;
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng của ma trận: ");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng của ma trận không hợp lệ!");
			sc.close();
			return;
		}
		try {
			do {
				System.out.println("Hãy nhập số hàng của ma trận: ");
				row = sc.nextInt();
			} while (row < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị hàng của ma trận không hợp lệ: ");
			sc.close();
			return;
		}
		try {
			do {
				System.out.println("Hãy nhập số cột của ma trận: ");
				column = sc.nextInt();
			} while (row < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị cột của ma trận không hợp lệ: ");
			sc.close();
			return;
		}
		int[][][] mang = new int[n][row][column];
		for (int i = 0; i < n; i++) {
			System.out.println("-----------------------------------------");
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					System.out.println("Hãy nhập giá trị của ma trận hàng " + (i + 1) + " cột " + (j + 1) + ": ");
					mang[i][j][j2] = sc.nextInt();
				}
				System.out.println();
			}
		}

		MaTran mt = new MaTran(row, column, mang);

		mt.xuatMaTran();
		mt.tinhTongMaTran();
		mt.tinhHieuMaTran();
	}

}

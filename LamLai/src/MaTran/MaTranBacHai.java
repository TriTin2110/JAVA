package MaTran;

import java.util.Scanner;

class MaTranBacHai {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 2, column = 2;

		// nhapMaTran(row, column);
		int[][][] maTran = nhapMaTran(row, column);

		System.out.println("Tổng của ma trận là: ");
		tinhTong(row, column, maTran);

		System.out.println("Hiệu của ma trận là: ");
		tinhHieu(row, column, maTran);

		System.out.println("Tích của ma trận là: ");
		tinhTich(row, column, maTran);
		sc.close();
	}

	// Nhập ma trận
	static int[][][] nhapMaTran(int row, int column) {
		boolean check = true;
		int[][][] maTran = new int[2][row][column];
		// Nhập giá trị
		for (int i1 = 0; i1 < 2; i1++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					do {
						try {
							System.out.println("Hãy nhập giá trị ở hàng " + i + " cột " + j + ": ");
							maTran[i1][i][j] = sc.nextInt();
							check = true;
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Giá trị nhập vào của ma trận không hợp lệ!");
							check = false;
						}
					} while (!check);
				}
			}
		}
		return maTran;

	}

	// Tính tổng
	static void tinhTong(int row, int column, int[][][] maTran) {
		int[][] sum = new int[row][column];
		for (int i1 = 0; i1 < 1; i1++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					sum[i][j] = maTran[i1][i][j] + maTran[i1 + 1][i][j];
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// Tính hiệu
	static void tinhHieu(int row, int column, int[][][] maTran) {
		int[][] hieu = new int[row][column];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					hieu[j][j2] = maTran[i][j][j2] - maTran[i + 1][j][j2];
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(hieu[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// Tính tích
	static void tinhTich(int row, int column, int[][][] maTran) {
		int[][] tich = new int[row][column];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					for (int k = 0; k < column; k++) {
						tich[j][j2] += maTran[i][j][k] * maTran[i + 1][k][j2];
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(tich[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

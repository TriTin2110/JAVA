import java.util.Scanner;

class MaTranA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row, column;
		try {
			do {
				System.out.println("Hãy nhập số lượng hàng trong ma trận");
				row = sc.nextInt();
			} while (row < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị HÀNG trong ma trận không hợp lệ!");
			sc.close();
			return;
		}
		try {
			do {
				System.out.println("Hãy nhập số lượng cột trong ma trận");
				column = sc.nextInt();
			} while (column < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị CỘT trong ma trận không hợp lệ!");
			sc.close();
			return;
		}

		int[][] maTran = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				try {
					System.out.println("Hãy nhập giá trị của phần tử hàng " + i + " cột " + j + ": ");
					maTran[i][j] = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử không hợp lệ!");
					sc.close();
					return;
				}
			}
		}

		ChucNangMaTranA cn = new ChucNangMaTranA(maTran, row, column);
		cn.timPhanTuLonNhat();
		cn.timSoNguyenTo();
		cn.inSoNguyenTo();
		cn.sapXepTangDanTheoCot();
		cn.timCotCoNhieuSoNguyenTo();
		sc.close();
	}

}

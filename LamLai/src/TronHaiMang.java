import java.util.Scanner;

class TronHaiMang {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng mảng: ");
					n = sc.nextInt();
					check = true;
				} while (n < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng mảng không hợp lệ!");
				check = false;
			}
		} while (!check);

		int[] mang = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("\n--------------------- Mảng " + (i + 1) + " ---------------------");
			do {
				try {
					do {
						System.out.println("Hãy nhập số lượng phần tử trong mảng " + (i + 1) + ": ");
						mang[i] = sc.nextInt();
						check = true;
					} while (n < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số lượng phần tử trong mảng " + (i + 1) + " không hợp lệ");
					check = false;
				}
			} while (!check);
		}
		nhapPhanTu(n, mang, check);
	}

	static void nhapPhanTu(int n, int[] mang, boolean check) {
		int[][] phanTu = null;
		int[][] sto = new int[n][mang.length];
		for (int i = 0; i < n; i++) {
			phanTu = new int[n][mang[i]];
			System.out.println("\n--------------------- Mảng " + (i + 1) + " ---------------------");
			for (int j = 0; j < mang[i]; j++) {
				do {
					try {
						System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
						phanTu[i][j] = sc.nextInt();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Giá trị của phần tử thứ " + (i + 1) + " không hợp lệ!");
						check = false;
					}
					sto[i][j] = phanTu[i][j];
				} while (!check);
			}

		}

		xuatMang(n, mang, phanTu);
	}

	static void xuatMang(int n, int[] mang, int[][] sto) {
		for (int i = 0; i < n; i++) {
			System.out.println("\n--------------------- Mảng " + (i + 1) + " ---------------------");
			for (int j = 0; j < mang[i]; j++) {
				System.out.println("Giá trị của phần tử thứ " + (i + 1) + " là: " + sto[i][j]);
			}
		}
	}
}

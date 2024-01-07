import java.util.Scanner;

class TronHaiMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n, m;

//Mảng 1
		System.out.println("\n----------------------\"Mảng 1\"----------------------\n");
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử của mảng 1: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng phần tử của mảng không hợp lệ!");
			sc.close();
			return;
		}

		int[] mang1 = new int[n];
		for (int i = 0; i < mang1.length; i++) {
			try {
				System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
				mang1[i] = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử thứ " + (i + 1) + ": ");
				sc.close();
				return;
			}
		}

		System.out.println("\n----------------------\"Mảng 2\"----------------------\n");
//Mảng 2
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử của mảng 2: ");
				m = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng phần tử của mảng không hợp lệ!");
			sc.close();
			return;
		}

		int[] mang2 = new int[m];
		for (int i = 0; i < mang2.length; i++) {
			try {
				System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
				mang2[i] = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử thứ " + (i + 1) + ": ");
				sc.close();
				return;
			}
		}
		SapXepMang sx = new SapXepMang();
		sx.sapXepMangCuoi(mang1, mang2);
		sc.close();
	}
}

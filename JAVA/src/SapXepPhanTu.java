import java.util.Scanner;

class SapXepPhanTu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử trong mảng: ");
				n = sc.nextInt();
			} while (n < 1);
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
		sapXep(mang);
		sc.close();
	}

	static void sapXep(int[] mang) {
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (mang[i] > mang[j]) {
					mang[i] = hoanDoi(mang[j], mang[j] = mang[i]);
				}
			}
		}
		for (int i : mang) {
			System.out.println(i);
		}
	}

	static int hoanDoi(int a, int b) {
		return a;
	}
}

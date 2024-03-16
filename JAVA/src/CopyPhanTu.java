import java.util.Scanner;

public class CopyPhanTu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử có trong mảng: ");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			System.out.println("Số lượng phần tử không hợp lệ!");
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
		output(mang);
		sc.close();
	}

	public static void output(int[] mang) {
		int[] mang2 = new int[mang.length];
		for (int i = 0; i < mang.length; i++) {
			mang2[i] = mang[i];
		}
		for (int i : mang2) {
			System.out.println(i);
		}
	}
}

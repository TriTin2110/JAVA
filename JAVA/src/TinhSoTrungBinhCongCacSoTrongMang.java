import java.util.Scanner;

class TinhSoTrungBinhCongCacSoTrongMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập giá trị số nguyên: ");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số nguyên không hợp lệ!");
			sc.close();
			return;
		}
		int[] mang = new int[n];
		out: for (int i = 0; i < mang.length; i++) {
			try {
				System.out.print("Hãy nhập giá trị của số nguyên thứ " + (i + 1) + ": ");
				mang[i] = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của số nguyên không hợp lệ!");
				sc.nextLine();
				i -= 1;
				continue out;
			}
		}
		output(mang);
		sc.close();
	}

	static void output(int[] mang) {
		int tong = 0;
		for (int i = 0; i < mang.length; i++) {
			tong += mang[i];
		}
		System.out.println(tong);
	}
}

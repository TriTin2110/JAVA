import java.util.Scanner;

class TimSoFibonacciThuN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int soNguyen = 0;
		boolean kiemTraSoNguyen = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
					soNguyen = sc.nextInt();
					kiemTraSoNguyen = true;
				} while (soNguyen < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của số nguyên không hợp lệ!");
				kiemTraSoNguyen = false;
			}
			sc.nextLine();
		} while (!kiemTraSoNguyen);
		outPut(soNguyen);
		sc.close();
	}

	static void outPut(int soNguyen) {
		int[] mang = new int[soNguyen];
		mang[0] = 1;
		mang[1] = 1;
		if (soNguyen == 1 || soNguyen == 2) {
			System.out.println(1);
		} else {
			for (int i = 2; i < soNguyen; i++) {
				mang[i] = mang[i - 1] + mang[i - 2];
			}
			System.out.println(mang[soNguyen - 1]);
		}
	}
}

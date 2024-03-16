import java.util.Scanner;

class SoISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n;
		try {
			do {
				System.out.println("Hãy nhập 1 số IBSN bất kỳ: ");
				n = sc.nextLong();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số IBSN không hợp lệ!");
			sc.close();
			return;
		}
		outPut(n);
		sc.close();
	}

	static void outPut(long n) {
		long[] mang = new long[10];
		String chuoi = Long.toString(n);
		for (int i = 0; i < chuoi.length(); i++) {
			mang[i] = (int) chuoi.charAt(i);
		}
		if (chuoi.length() != 10) {
			System.out.println("Đây không phải là số ISBN!");
			return;
		} else {
			long tong = 0;
			for (int i = 0; i < mang.length; i++) {
				tong += mang[i] + i;
			}
			System.out.println((tong % 11 == 0) ? "Đây là số ISBN!" : "Đây không phải là số ISBN!");
		}
	}
}

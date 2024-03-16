import java.util.Scanner;

class KiemTraDaySoArmsStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số nguyên không hợp lệ!");
			sc.close();
			return;
		}
		output(n);
		sc.close();
	}

	static void output(int n) {
		int tong = 0;
		int temp = n;
		int dem;
		// Đổi thập phân sang thập lục phân
		System.out.println(Integer.toHexString(n));

		String chuoi = Integer.toString(n);
		dem = chuoi.length();
		while (n > 0) {
			tong += Math.pow((n % 10), dem);
			n /= 10;
		}
		if (tong == temp) {
			System.out.println("ArmsStrong");
		}
	}
}

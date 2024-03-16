import java.util.Scanner;

class TimUocSoNguyen {

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
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
	}
}

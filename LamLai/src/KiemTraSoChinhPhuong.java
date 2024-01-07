import java.util.Scanner;

class KiemTraSoChinhPhuong {
	public static void main(String[] args) {
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
		outPut(n);
		sc.close();
	}

	static void outPut(int n) {
		boolean check = false;
		for (int i = 0; i < n; i++) {
			if (Math.sqrt(n) == i) {
				check = true;
				break;
			}
		}
		System.out.println((check || n == 0 || n == 1) ? "Số vừa nhập là số chính phương"
				: "Số vừa nhập không phải là số chính phương");
	}
}

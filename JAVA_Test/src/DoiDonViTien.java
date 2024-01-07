import java.util.Scanner;

public class DoiDonViTien {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int check;
			double tien;
			System.out.println("Hãy chọn 1 trong 2 phương thức sau:");
			System.out.println("1. Đổi tiền Việt sang tiền $ và €");
			System.out.println("2. Đổi tiền $ và € sang tiền Việt");
			System.out.print("==> ");
			check = sc.nextInt();
			if (check == 1) {
				System.out.print("Hãy nhập số tiền mà bạn muốn đổi: ");
				tien = sc.nextDouble();
				System.out.printf("%.3fVNĐ ==> %.2f$\n", tien, (tien / 23.640));
				System.out.printf("%.3fVNĐ ==> %.2f€\n", tien, (tien / 26.451));

			} else if (check == 2) {
				System.out.print("Hãy nhập số tiền mà bạn muốn đổi: ");
				tien = sc.nextDouble();
				System.out.printf("%.2f$ ==> %.3fVNĐ\n", tien, (tien * 23.640));
				System.out.printf("%.2f€ ==> %.3fVNĐ\n", tien, (tien * 26.451));
			} else {
				break;
			}
		}
	}
}

package ArrowFunction;

import java.util.Scanner;

class GiaiPhuongTrinhBacHai {
	static boolean check = true;
	static Scanner sc = new Scanner(System.in);
	static double a, b, c;

	public static void main(String[] args) {
		nhapGiaTri();
	}

	static void nhapGiaTri() {
		// Nhập a
		do {
			try {
				System.out.println("Hãy nhập giá trị của a: ");
				a = sc.nextDouble();
				check = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử a không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		// Nhập b
		do {
			try {
				System.out.println("Hãy nhập giá trị của b: ");
				b = sc.nextDouble();
				check = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử b không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		// Nhập c
		do {
			try {
				System.out.println("Hãy nhập giá trị của c: ");
				c = sc.nextDouble();
				check = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử c không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		outPut();
	}

	static void outPut() {
		GiaiPT giai = () -> {
			double delta = Math.pow(b, 2) - (4 * a * c);
			if (delta < 0) {
				System.out.println("Phương trình vô nghiệm!");

			} else if (delta == 0) {
				System.out.println("Phương trình có nghiệm kép: " + ((-b) / (2 * a)));
			} else {
				System.out.println("Phương trình có 2 nghiệm phân biệt:");
				System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
				System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
			}
		};
		giai.giaiPT();
	}
}

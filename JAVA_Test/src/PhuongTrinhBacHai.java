import java.util.Scanner;

public class PhuongTrinhBacHai {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		System.out.print("Hãy nhập a: ");
		a = sc.nextDouble();
		System.out.print("Hãy nhập b: ");
		b = sc.nextDouble();
		System.out.print("Hãy nhập c: ");
		c = sc.nextDouble();
		double delta = Math.pow(b, 2) - (4 * a * c);
		if (a == 0) {
			System.out.print("Dữ kiện không hợp lệ: ");
		} else {
			if (delta < 0) {
				System.out.print("Phương trình vô nghiệm!");
			} else if (delta == 0) {
				System.out.println("Phương trình có nghiệm kép x0= " + (-b / (2 * a)));
			} else {
				System.out.println("Phương trình có 2 nghiệm phân biệt!");
				System.out.println(
						"x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + ", x2= " + ((-b - Math.sqrt(delta)) / (2 * a)));
			}
		}
		sc.close();
	}
}

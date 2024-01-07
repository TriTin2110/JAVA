import java.util.Scanner;

public class Chuong_Trinh_Tinh_Tong {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hãy nhập số nguyên thứ nhất: ");
		int num1 = scanner.nextInt();
		System.out.print("Hãy nhập số nguyên thứ hai: ");
		int num2 = scanner.nextInt();
		num2 = 6;
		System.out.println("Tổng của hai số nguyên là: "+(num1+num2));
	}
}

import java.util.Scanner;

public class KiemTraDaySoArmStrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
				n = sc.nextInt();
			} while (n < 1);
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

//		int soArmsStrong = 0;
//		int n1 = n;
//		int temp = 0;
//		int chieuDai = Integer.toString(n).length();

//Cách 1
//		while (n1 > 0) {
//			temp = n1 % 10;
//			soArmsStrong += Math.pow(temp, chieuDai);
//			n1 /= 10;
//		}
//		System.out.println(
//				(soArmsStrong == n) ? "Số vừa nhập là số Armstrong" : "Số vừa nhập không phải là số Armstrong");

//Cách 2
		int[] mang = new int[Integer.toString(n).length()];
		int n2 = n;
		for (int j = 0; j < mang.length; j++) {
			mang[j] = (int) Math.pow((n2 % 10), mang.length);
			n2 /= 10;
		}
		for (int i : mang) {
			n2 += i;
		}
		System.out.println((n2 == n) ? "Số vừa nhập là số Armstrong" : "Số vừa nhập không phải là số Armstrong");
	}
}

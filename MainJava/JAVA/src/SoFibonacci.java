import java.util.Scanner;

class SoFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
		int n = sc.nextInt();
		giai(n);
		sc.close();
	}

	static void giai(int n) {
		int[] mang = new int[n];
		int i = 0;
		if (n == 0) {
			System.out.println("Vị trí tại n = " + n + " là: 0");
		} else if (n == 1 || n == 2) {
			System.out.println("Vị trí tại n = " + n + " là: 1");
		} else {
			while (i != n) {
				if (i == 0) {
					mang[0] = 1;
					mang[1] = 1;
					i += 2;
				} else {
					mang[i] = mang[i - 1] + mang[i - 2];
					i++;
				}
			}
			System.out.println("Vị trí tại n = " + n + " là: " + mang[i - 1]);
		}

	}
}

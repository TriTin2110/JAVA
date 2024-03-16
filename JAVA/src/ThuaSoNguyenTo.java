import java.util.ArrayList;
import java.util.Scanner;

class ThuaSoNguyenTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
		int n = sc.nextInt();
		sc.close();
		soNguyenTo(n);
	}

	static void soNguyenTo(int n) {
		if (n == 1 || n == 0) {
			System.out.println(n);
		} else {
			ArrayList<Integer> mangSoNguyenTo = new ArrayList<Integer>();
			out: for (int i = 2; i <= n; i++) {
				for (int j = 2; j < n; j++) {
					if (i == 2) {
						mangSoNguyenTo.add(i);
						continue out;
					}
					if (i % j == 0 && i != j) {
						continue out;
					}
				}
				mangSoNguyenTo.add(i);
			}
			System.out.print(n + " = ");
			int i = 0;
			while (n != 1) {
				if (n % mangSoNguyenTo.get(i) == 0 && n != mangSoNguyenTo.lastIndexOf(mangSoNguyenTo)) {
					n /= mangSoNguyenTo.get(i);
					System.out.print((n != 1) ? mangSoNguyenTo.get(i) + "x" : mangSoNguyenTo.get(i));

				} else {
					i++;
				}
			}
		}
	}
}

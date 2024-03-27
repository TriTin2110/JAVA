import java.util.Scanner;

class TongHaiSoTrongMangRaInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Nhập vào 1 mảng bất kỳ 5 phần tử
		// Nhập vào n
		// Nếu n = mang[i]+mang[j]
		// Output: i, j
		Scanner sc = new Scanner(System.in);
		int doDaiMang = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập độ dài của mảng: ");
					doDaiMang = sc.nextInt();
					check = true;
				} while (doDaiMang < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Độ dài của mảng không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		int[] mang = new int[doDaiMang];
		for (int i = 0; i < mang.length; i++) {
			do {
				try {
					System.out.println("Hãy nhập giá trị của phần tử thứ " + i + ": ");
					mang[i] = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
		}
		int n = 0;
		do {
			try {
				do {
					System.out.println("Hãy nhập n: ");
					n = sc.nextInt();
					check = true;
				} while (doDaiMang < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số nhập vào không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		output(mang, n);
		sc.close();
	}

	static void output(int[] mang, int n) {
		for (int i = 0; i < mang.length - 1; i++) {
			for (int j = i + 1; j < mang.length; j++) {
				if (n == (mang[i] + mang[j])) {
					System.out.println(i + ", " + j);
				}
			}
		}
	}
}

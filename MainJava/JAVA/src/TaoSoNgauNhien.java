import java.util.Scanner;

class TaoSoNgauNhien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử ngẫu nhiên!");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng phần tử không hợp lệ!");
			sc.close();
			return;
		}
		outPut(n);
		sc.close();
	}

	static void outPut(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print((int) (Math.random() * 100) + "\t");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
}

import java.util.Scanner;

class ThapPhanSangNhiPhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập 1 số thập phân bất kỳ: ");
				n = sc.nextInt();
			} while (n == 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị thập phân không hợp lệ!");
			sc.close();
			return;
		}
		output(n);
		sc.close();
	}

	static void output(int n) {
		String nhiPhan = "";
		boolean check = false;
		while (n != 0) {
			if (n < 0) {
				n = Math.abs(n);
				check = true;
			}
			nhiPhan = (n % 2) + nhiPhan;
			n /= 2;
		}
		System.out.println((check) ? "-" + nhiPhan : nhiPhan);
	}
}

import java.util.Scanner;

public class DoiThapPhanSangBatPhan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			System.out.println("Hãy nhập 1 số thập phân bất kỳ: ");
			n = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Giá trị thập phân không hợp lệ!");
			sc.close();
			return;
		}
		output(n);
		sc.close();
	}

	public static void output(int n) {
		String batPhan = "";
		while (n > 0) {
			batPhan = (n % 8) + batPhan;
			n /= 8;
		}
		System.out.println(batPhan);
	}
}

import java.util.Scanner;

public class DoiBatPhanSangThapPhan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int batPhan;
		try {

			System.out.println("Hãy nhập 1 số bát phân: ");
			batPhan = sc.nextInt();

		} catch (Exception e) {
			System.out.println("Giá trị của số bát phân không hợp lệ!");
			sc.close();
			return;
		}
		output(batPhan);
		sc.close();
	}

	public static void output(int batPhan) {
		int temp = 0;
		int thapPhan = 0;
		int dem = 0;
		boolean soAm = false;
		while (batPhan != 0) {
			if (batPhan < 0) {
				batPhan = Math.abs(batPhan);
				soAm = true;
			}
			temp = (batPhan % 10);
			if (temp == 9) {
				System.out.println("Giá trị bát phân không hợp lệ!");
				return;
			}
			thapPhan += temp * Math.pow(8, dem);
			dem++;
			batPhan /= 10;
		}
		System.out.println((soAm) ? "-" + thapPhan : thapPhan);
	}
}

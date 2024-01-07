import java.util.Scanner;

public class ChuyenSoNhiPhanSangSoThapPhan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 số thập phân bất kì: ");
		int n = sc.nextInt();
		int soMu = 0;
		int soThapPhan = 0;
		int temp = 0;
		while (true) {
			if (n == 0) {
				break;
			} else {
				/*
				 * Cho biến temp = số dư của n chia cho 10 soThapPhan sẽ bằng soThapPhan + temp
				 * * 2^(soMu) Sau đó chia lấy thương của n/10 và tăng số mũ lên 1
				 */
				temp = n % 10;
				soThapPhan += temp * Math.pow(2, soMu);
				n = n / 10;
				soMu++;

			}
		}
		System.out.println(soThapPhan);
	}
}

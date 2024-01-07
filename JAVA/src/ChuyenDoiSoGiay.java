import java.util.Scanner;

public class ChuyenDoiSoGiay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số giây: ");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			System.out.println("Số giây không hợp lệ!");
			sc.close();
			return;
		}
		outPut(n);
		sc.close();
	}

	public static void outPut(int giay) {
		String soGio = Integer.toString(giay / 3600);
		soGio = (soGio.compareTo("10") < 0) ? "0" + soGio : soGio;
		String soPhut = Integer.toString((giay % 3600) / 60);
		soPhut = (soPhut.compareTo("10") < 0) ? "0" + soPhut : soPhut;
		String soGiay = Integer.toString((giay % 3600) % 60);
		soGiay = (soGiay.compareTo("10") < 0) ? "0" + soGiay : soGiay;
		System.out.println("==> " + soGio + ":" + soPhut + ":" + soGiay);
	}
}

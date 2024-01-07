import java.util.Scanner;

class NhiPhanSangThapPhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long nhiPhan;
		try {
			do {
				System.out.println("Hãy nhập 1 số nhị phân bất kỳ: ");
				nhiPhan = sc.nextLong();
			} while (nhiPhan == 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị nhị phân không hợp lệ!");
			sc.close();
			return;
		}
		String nhiPhanString = Long.toString(nhiPhan);
		for (int i = 0; i < nhiPhanString.length(); i++) {
			if (nhiPhanString.charAt(i) != '0' && nhiPhanString.charAt(i) != '1' && nhiPhanString.charAt(i) != '-') {
				System.out.println("Giá trị nhị phân không hợp lệ");
				sc.close();
				return;
			}
		}
		outPut(nhiPhan);
		sc.close();
	}

	static void outPut(long nhiPhan) {
		long temp = 0;
		long thapPhan = 0;
		int dem = 0;
		boolean check = false;
		while (nhiPhan != 0) {
			if (nhiPhan < 0) {
				nhiPhan = Math.abs(nhiPhan);
				check = true;
			}
			temp = nhiPhan % 10;
			thapPhan += temp * Math.pow(2, dem);
			dem++;
			nhiPhan /= 10;
		}
		System.out.println((check) ? "-" + thapPhan : thapPhan);
	}
}

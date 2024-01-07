import java.util.Scanner;

class DoiBatPhanSangThapPhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int batPhan;
		try {
			do {
				System.out.println("Hãy nhập giá trị của bát phân: ");
				batPhan = sc.nextInt();
			} while (batPhan == 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của bát phân không hợp lệ!");
			sc.close();
			return;
		}
		char[] kiemTraBatPhan = Integer.toString(batPhan).toCharArray();
		for (int i = 0; i < kiemTraBatPhan.length; i++) {
			if (kiemTraBatPhan[i] == '8' || kiemTraBatPhan[i] == '9') {
				System.out.println("Giá trị của bát phân không hợp lệ");
				sc.close();
				return;
			}
		}
		outPut(batPhan);
		sc.close();
	}

	static void outPut(int batPhan) {
		int temp = 0;
		int thapPhan = 0;
		int dem = 0;
		boolean check = false;
		if (batPhan < 0) {
			batPhan = Math.abs(batPhan);
			check = true;
		}
		while (batPhan > 0) {
			temp = batPhan % 10;
			thapPhan += temp * Math.pow(8, dem);
			dem++;
			batPhan /= 10;
		}

		System.out.println((check) ? "-" + thapPhan : thapPhan);
	}
}

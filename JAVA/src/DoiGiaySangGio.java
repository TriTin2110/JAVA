import java.util.Scanner;

class DoiGiaySangGio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int giay;
		try {
			do {
				System.out.println("Hãy nhập số giây: ");
				giay = sc.nextInt();
			} while (giay < 1);
		} catch (Exception e) {
			System.out.println("Giá trị giây không hợp lệ");
			sc.close();
			return;
		}
		output(giay);
		sc.close();
	}

	static void output(int giay) {
		String gio = Integer.toString(giay / 3600);
		gio = (gio.compareTo("10") < 0) ? "0" + gio : gio;

		String phut = Integer.toString((giay % 3600) / 60);
		phut = (phut.compareTo("10") < 0) ? "0" + phut : phut;

		String s = Integer.toString((giay % 3600) % 60);
		s = (s.compareTo("10") < 0) ? "0" + s : s;

		System.out.println(gio + ":" + phut + ":" + s);
	}
}

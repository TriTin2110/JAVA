import java.util.Scanner;

class DoiGioSangGiay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gio, phut, giay;
//giờ------------------------------------------------------------------
		try {
			do {
				System.out.println("Hãy nhập số giờ: ");
				gio = sc.nextInt();
			} while (gio < 0);
		} catch (Exception e) {
			System.out.println("Giá trị của giờ không hợp lệ!");
			sc.close();
			return;
		}

// phút------------------------------------------------------------------
		try {
			do {
				System.out.println("Hãy nhập số phút: ");
				phut = sc.nextInt();
			} while (phut < 0);
		} catch (Exception e) {
			System.out.println("Giá trị của phút không hợp lệ!");
			sc.close();
			return;
		}

//giây------------------------------------------------------------------
		try {
			do {
				System.out.println("Hãy nhập số giây: ");
				giay = sc.nextInt();
			} while (giay < 0);
		} catch (Exception e) {
			System.out.println("Giá trị của giây không hợp lệ!");
			sc.close();
			return;
		}
		output(gio, phut, giay);
		sc.close();
	}

//output------------------------------------------------------------------
	static void output(int gio, int phut, int giay) {
		int kq = (gio * 3600) + (phut * 60) + giay;
		System.out.println(kq);
	}
}

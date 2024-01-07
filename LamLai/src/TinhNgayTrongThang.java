import java.util.Scanner;

class TinhNgayTrongThang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int thang, nam;
		try {
			do {
				System.out.println("Hãy nhập tháng: ");
				thang = sc.nextInt();
			} while (thang < 1 || thang > 12);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của tháng không hợp lệ!");
			sc.close();
			return;
		}
		try {
			do {
				System.out.println("Hãy nhập năm: ");
				nam = sc.nextInt();
			} while (nam < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của năm không hợp lệ!");
			sc.close();
			return;
		}
		output(thang, nam);
		sc.close();
	}

	static void output(int thang, int nam) {
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			System.out.println("Tháng " + thang + " trong năm " + nam + " có 31 ngày!");
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11: {
			System.out.println("Tháng " + thang + " trong năm " + nam + " có 30 ngày!");
			break;
		}
		default: {
			System.out.println((nam % 4 == 0 && nam % 100 != 0 || nam % 400 == 0)
					? "Tháng " + thang + " trong năm " + nam + " có 29 ngày!"
					: "Tháng " + thang + " trong năm " + nam + " có 28 ngày!");
		}
		}
	}
}

import java.util.Scanner;

class SapXepChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng chuỗi có trong mảng: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng chuỗi của mảng không hợp lệ!");
			sc.close();
			return;
		}
		sc.nextLine();
		String[] chuoi = new String[n];
		for (int i = 0; i < chuoi.length; i++) {
			System.out.println("Hãy nhập chuỗi thứ " + (i + 1) + ": ");
			chuoi[i] = sc.nextLine();
		}
		output(chuoi);
		sc.close();
	}

	static void output(String[] chuoi) {
		for (int i = 0; i < chuoi.length - 1; i++) {
			for (int j = i + 1; j < chuoi.length; j++) {
				if (chuoi[i].compareTo(chuoi[j]) > 0) {
					chuoi[i] = hoanDoi(chuoi[j], chuoi[j] = chuoi[i]);
				}
			}
		}
		for (String string : chuoi) {
			System.out.println(string);
		}
	}

	static String hoanDoi(String a, String b) {
		return a;
	}
}

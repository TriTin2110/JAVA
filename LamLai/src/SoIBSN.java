import java.util.Scanner;

class SoIBSN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long IBSN;
		try {
			do {
				System.out.println("Hãy nhập 1 số ISBN: ");
				IBSN = sc.nextLong();
			} while (IBSN < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số IBSN không hợp lệ!");
			sc.close();
			return;
		}
		output(IBSN);
		sc.close();
	}

	static void output(long IBSN) {
		String chuoi = Long.toString(IBSN);
		boolean check = true;
		long tong = 0;
		long dem = 1;
		for (int i = chuoi.length() - 1; i >= 0; i--) {
			tong += dem * (chuoi.charAt(i) - '0');
			dem++;
		}
		if (chuoi.length() != 10) {
			check = false;
		} else if (tong % 11 != 0) {
			check = false;
		} else {
			check = true;
		}
		System.out.println((check) ? "Số vừa nhập là số ISBN!" : "Số vừa nhập không phải là số ISBN!");
	}
}

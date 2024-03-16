import java.util.Scanner;

public class DoiTien {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luaChon;
		try {
			do {
				System.out.println("Mời nhập lựa chọn:");
				System.out.println("1. Đổi tiền đô sang tiền Việt");
				System.out.println("2. Đổi tiền việt sang đô");
				System.out.println("3. Đổi tiền việt sang Eur");
				System.out.println("4. Đổi tiền Eur sang tiền việt");
				System.out.println("Lựa chọn của bạn là: ");
				luaChon = sc.nextInt();
			} while (luaChon < 1 || luaChon > 4);
		} catch (Exception e) {
			System.out.println("Lựa chọn của bạn không hợp lệ!");
			return;
		}
		sc.nextLine();
		if (luaChon == 1) {
			double tienDo = 0;
			try {
				do {
					System.out.println("Hãy nhập số tiền $: ");
					tienDo = sc.nextDouble();
				} while (tienDo < 1);
			} catch (Exception e) {
				System.out.println("Số tiền không hợp lệ");
				return;
			}
			DoiTienDoSangTienViet doiTienDoSangTienViet = new DoiTienDoSangTienViet(tienDo);
			VND vnd = new VND(doiTienDoSangTienViet.doiTien());
			System.out.println(vnd.xuLyTienTe());

		}

		else if (luaChon == 2) {
			double tienViet = 0;
			try {
				do {
					System.out.println("Hãy nhập số tiền VNĐ: ");
					tienViet = sc.nextDouble();
				} while (tienViet < 1);
			} catch (Exception e) {
				System.out.println("Số tiền không hợp lệ");
				return;
			}
			DoiTienVietSangTienDo doiTienVietSangTienDo = new DoiTienVietSangTienDo(tienViet);
			System.out.printf("%.2f$", doiTienVietSangTienDo.doiTienVietSangDo());
		}

		else if (luaChon == 3) {
			double tienViet = 0;
			try {
				do {
					System.out.println("Hãy nhập số tiền VNĐ: ");
					tienViet = sc.nextDouble();
				} while (tienViet < 1);
			} catch (Exception e) {
				System.out.println("Số tiền không hợp lệ");
				return;
			}
			EurVaViet eurVaViet = new EurVaViet();
			eurVaViet.VietSangEur(tienViet);
			System.out.printf("%.2f€", eurVaViet.doiTienVietSangEur());
		}

		else {
			double tienEur = 0;
			try {
				do {
					System.out.println("Hãy nhập số tiền €: ");
					tienEur = sc.nextDouble();
				} while (tienEur < 1);
			} catch (Exception e) {
				System.out.println("Số tiền không hợp lệ");
				return;
			}
			EurVaViet eurVaViet = new EurVaViet();
			eurVaViet.EurSangViet(tienEur);
			VND vnd = new VND(eurVaViet.doiEurSangTienViet());
			System.out.println(vnd.xuLyTienTe());
		}
	}
}

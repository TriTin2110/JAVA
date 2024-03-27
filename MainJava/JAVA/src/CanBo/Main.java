package CanBo;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int check = 0;
		int soLuongCanBo = 0;
		QLCB ql = new QLCB();
		do {
			try {
				do {
					System.out.println("Hãy nhập lựa chọn của bạn: ");
					System.out.println("1. Tạo danh sách cán bộ mới");
					System.out.println("2. Thêm cán bộ mới");
					System.out.println("3. In thông tin về danh sách cán bộ");
					System.out.println("4. Thoát");
					System.out.println("==> ");
					check = sc.nextInt();
				} while (check < 1 && check > 4);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lựa chọn không hợp lệ!");
				sc.close();
				return;
			}
			switch (check) {
			case 1: {
				try {
					do {
						System.out.println("Hãy nhập số lượng cán bộ có trong danh sách: ");
						soLuongCanBo = sc.nextInt();
					} while (soLuongCanBo < 1);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số lượng cán bộ không hợp lệ!");
					sc.close();
					return;
				}
				ql.themDanhSachCanBo(soLuongCanBo);
				break;
			}
			case 3: {
				ql.inThongTinDanhSach();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + check);
			}
		} while (check != 4);

	}
}

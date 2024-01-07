package NganHang;

import java.util.Scanner;

class MainTaiKhoan {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		boolean check = true;
		DanhSachTaiKhoan ds = new DanhSachTaiKhoan();
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Thêm tài khoản");
						System.out.println("2. Kiểm tra tài khoản");
						System.out.println("3. Nạp tiền vào tài khoản");
						System.out.println("4. Rút tiền");
						System.out.println("5. Đáo hạn");
						System.out.println("6. Chuyển tiền");
						System.out.println("0. Thoát");
						System.out.print("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose > 6 || choose < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			// To do:
			chonLua(choose, check, ds);
		} while (choose != 0);
	}

	static void chonLua(int choose, boolean check, DanhSachTaiKhoan ds) {
		long soTaiKhoan = 0;
		switch (choose) {
		case 1: {
			String tenTaiKhoan;
			do {
				try {
					do {
						System.out.println("Hãy nhập số tài khoản: ");
						soTaiKhoan = sc.nextLong();
						check = true;
					} while (soTaiKhoan < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số tài khoản không hợp lệ!");
					check = false;
				}
			} while (!check);
			sc.nextLine();
			System.out.println("Hãy nhập tên của tài khoản: ");
			tenTaiKhoan = sc.nextLine();
			Account ac = new Account(soTaiKhoan, tenTaiKhoan);
			ds.themTaiKhoan(ac);
			break;
		}
		case 2: {
			do {
				try {
					do {
						System.out.println("Hãy nhập số tài khoản: ");
						soTaiKhoan = sc.nextLong();
						check = true;
					} while (soTaiKhoan < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số tài khoản không hợp lệ!");
					check = false;
				}
			} while (!check);
			Account ac = new Account(soTaiKhoan);
			ds.inThongTinTaiKhoan(ac);
			break;
		}

		case 3: {
			double tienNap = 0;
			do {
				try {
					do {
						System.out.println("Hãy nhập số tài khoản: ");
						soTaiKhoan = sc.nextLong();
						check = true;
					} while (soTaiKhoan < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số tài khoản không hợp lệ!");
					check = false;
				}
			} while (!check);

			Account ac = new Account(soTaiKhoan);
			if (ds.kiemTraTaiKhoan(ac)) {
				// Nhập số tiền nạp
				do {
					try {
						do {
							System.out.println("Hãy nhập số tiền nạp: ");
							tienNap = sc.nextDouble();
							check = true;
						} while (tienNap < 0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Số tài khoản không hợp lệ!");
						check = false;
					}
				} while (!check);
				ds.napTienVaoTaiKhoan(ac, tienNap);
			}
			break;
		}

		// Rút tiền
		case 4: {
			double tienRut = 0;
			do {
				try {
					do {
						System.out.println("Hãy nhập số tài khoản: ");
						soTaiKhoan = sc.nextLong();
						check = true;
					} while (soTaiKhoan < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số tài khoản không hợp lệ!");
					check = false;
				}
			} while (!check);

			Account ac = new Account(soTaiKhoan);
			if (ds.kiemTraTaiKhoan(ac)) {
				// Nhập số tiền nạp
				do {
					try {
						do {
							System.out.println("Hãy nhập số tiền rút: ");
							tienRut = sc.nextDouble();
							check = true;
						} while (tienRut < 0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Số tài khoản không hợp lệ!");
						check = false;
					}
				} while (!check);
				ds.rutTien(ac, tienRut);
			}
			break;
		}

		// Đáo hạn
		case 5: {
			do {
				try {
					do {
						System.out.println("Hãy nhập số tài khoản: ");
						soTaiKhoan = sc.nextLong();
						check = true;
					} while (soTaiKhoan < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Số tài khoản không hợp lệ!");
					check = false;
				}
			} while (!check);
			Account ac = new Account(soTaiKhoan);
			ds.daoHan(ac);
		}

		// Chuyển tiền
		case 6: {
			double tienGui = 0, tienNhan = 0;
			Account ac, ac2;
			do {
				do {
					try {
						do {
							System.out.println("Hãy nhập số tài khoản gửi: ");
							soTaiKhoan = sc.nextLong();
							check = true;
						} while (soTaiKhoan < 0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Số tài khoản không hợp lệ!");
						check = false;
					}
				} while (!check);
				ac = new Account(soTaiKhoan);
			} while (!ds.kiemTraTaiKhoan(ac));

			do {
				do {
					try {
						do {
							System.out.println("Hãy nhập số tài khoản nhận: ");
							soTaiKhoan = sc.nextLong();
							check = true;
						} while (soTaiKhoan < 0);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Số tài khoản không hợp lệ!");
						check = false;
					}
				} while (!check);
				ac2 = new Account(soTaiKhoan);
			} while (!ds.kiemTraTaiKhoan(ac2));

			try {
				do {
					System.out.println("Hãy nhập số tiền gửi: ");
					tienGui = sc.nextDouble();
					check = true;
				} while (tienGui < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị tiền gửi không hợp lệ!");
				check = false;
			}

			ds.chuyenTien(ac, ac2, tienGui, tienGui);
		}
		}
	}
}

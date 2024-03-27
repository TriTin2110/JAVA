import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class ChuyenSoNguyenThanhSoLaMa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int soNguyen = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
					soNguyen = sc.nextInt();
					check = true;
				} while (soNguyen < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của số nguyên không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		String ketQua = "";
		outPut(soNguyen);
		sc.close();
	}

	static String XuLyHangDonVi(int phanDu) {
		String c = "";
		switch (phanDu) {
		case 1: {

			c = "I";
			break;
		}
		case 2: {
			c = "II";
			break;
		}
		case 3: {
			c = "III";
			break;
		}
		case 4: {
			c = "IV";
			break;
		}
		case 5: {
			c = "V";
			break;
		}
		case 6: {
			c = "VI";
			break;
		}
		case 7: {
			c = "VII";
			break;
		}
		case 8: {
			c = "VIII";
			break;
		}
		case 9: {
			c = "IX";
			break;
		}
		}
		return c;
	}

	// Hàm xử lý hàng chục
	static String XuLyHangChuc(int soNguyen, int phanDu) {
		String ketQua = "";
		String hangChuc = "";
		while (soNguyen > 0) {
			// Hàng chục từ 1 -> 4
			do {
				switch (soNguyen) {
				case 1, 2, 3: {
					do {
						soNguyen--;
						hangChuc = "X";
						ketQua = hangChuc + ketQua;
					} while (soNguyen > 0);
					break;
				}

				case 4: {
					soNguyen -= 4;
					hangChuc = "XL";
					ketQua = hangChuc + ketQua;
					break;
				}

				case 5: {
					soNguyen -= 5;
					hangChuc = "L";
					ketQua = hangChuc + ketQua;
					break;
				}

				case 6, 7, 8: {
					soNguyen -= 1;
					hangChuc = "X";
					ketQua = hangChuc + ketQua;
					break;
				}
				case 9: {
					soNguyen -= 9;
					hangChuc = "IC";
					ketQua = hangChuc + ketQua;
					break;
				}

				}
			} while (soNguyen > 0);
		}

		return ketQua + XuLyHangDonVi(phanDu);
	}

	// Hàm xử lý trăm
	static Deque<String> XuLy(int soNguyen) {
		String hangTram = "";

		Deque<String> ketQua = new ArrayDeque<String>();
		String kq = "";
		do {
			// Hàng đơn vị
			if (soNguyen > 0 && soNguyen < 10) {
				kq = XuLyHangDonVi(soNguyen) + ketQua;
				kq = kq.substring(0, kq.indexOf('['));
				ketQua.offer(kq);
				soNguyen /= 10;

				// Hàng chục
			} else if (soNguyen > 10 && soNguyen < 100) {
				int hangChuc = soNguyen / 10;
				kq = XuLyHangChuc(hangChuc, 0) + ketQua;
				kq = kq.substring(0, kq.indexOf('['));
				ketQua.offer(kq);
				soNguyen %= 10;
			} else {
				int hangTramInterger = soNguyen / 100;

				// Hàng trăm từ 1-> 9

				do {

					switch (hangTramInterger) {
					case 1, 2, 3: {
						do {
							hangTramInterger--;
							hangTram = "C";
							kq = hangTram + ketQua;
							kq = kq.substring(0, kq.indexOf('['));
							ketQua.offer(kq);
						} while (hangTramInterger > 0);
						break;
					}

					case 4: {
						hangTramInterger -= 4;
						hangTram = "CD";
						kq = hangTram + ketQua;
						kq = kq.substring(0, kq.indexOf('['));
						ketQua.offerLast(kq);
						break;
					}
					case 5: {
						hangTramInterger -= 5;
						hangTram = "D";
						kq = hangTram + ketQua;
						kq = kq.substring(0, kq.indexOf('['));
						ketQua.offerFirst(kq);
						break;
					}

					case 6, 7, 8: {
						hangTramInterger -= 1;
						hangTram = "C";
						kq = hangTram + ketQua;
						kq = kq.substring(0, kq.indexOf('['));
						ketQua.offer(kq);
						break;
					}
					case 9: {
						hangTramInterger -= 9;
						hangTram = "CM";
						kq = hangTram + ketQua;
						kq = kq.substring(0, kq.indexOf('['));
						ketQua.offer(kq);
						break;
					}
					}
				} while (hangTramInterger > 0);
			}
			soNguyen %= 100;

		} while (soNguyen > 0);

		return ketQua;

	}

	static void outPut(int soNguyen) {
		XuLy(soNguyen);
		for (String ketQua : XuLy(soNguyen)) {
			System.out.print(ketQua);
		}
	}
}

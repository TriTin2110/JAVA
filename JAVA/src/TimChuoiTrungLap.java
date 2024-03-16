import java.util.Scanner;

class TimChuoiTrungLap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int chieuDaiMang = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập độ dài của mảng: ");
					chieuDaiMang = sc.nextInt();
					check = true;
				} while (chieuDaiMang < 2);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Chiều dài của mảng không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		String[] mang = new String[chieuDaiMang];
		for (int i = 0; i < mang.length; i++) {
			System.out.println("Hãy nhập chuỗi thứ " + (i + 1) + ": ");
			mang[i] = sc.nextLine();
		}
		outPut(mang);
		sc.close();
	}

	static void outPut(String[] mang) {
		// Duyệt từ đầu chuỗi đến cuối chuỗi mỗi lần lấy 2 từ
		// Sử dụng string.contains nếu chứa 2 từ thì sẽ duyệt thêm ký tự tiếp theo
		// Nếu từ tiếp theo không trùng thì sẽ loại bỏ từ đó khỏi chuỗi
		// Nếu cả chuỗi không trùng với tất cả các chuỗi khác thì sẽ lấy chuỗi tiếp theo
		// duyệt

		String kq = "";
		out: for (int i = 0; i < mang.length - 1; i++) {
			int dau = 0, sau = 2;
			String chuoiDau = "";
			String ketQua = "";
			for (int j = 0; j < mang[i].length() - 1; j++) {
				if (j == 0 || ketQua == "") {
					for (int j2 = dau; j2 < sau; j2++) {
						// chuoiDau sẽ nhận lần lượt 2 ký tự liền kề
						chuoiDau += mang[i].charAt(j2);
					}
				} else {
					// Nếu đã có 2 từ trùng thì sẽ lấy ký tự tiếp theo
					chuoiDau += mang[i].charAt(sau - 1);
				}

				if (i < mang.length - 1) {
					if (i == 0) {
						if (mang[i + 1].contains(chuoiDau)) {
							ketQua = ""; // Làm mới chuỗi kết quả để nhận toàn bộ ký tự trùng
							ketQua += chuoiDau;
						} else {
							chuoiDau = ""; // Làm mới chuỗi đầu để nhận ký tự tiếp theo
						}
					} else {
						if (mang[i + 1].contains(chuoiDau)) {
							ketQua = ""; // Làm mới chuỗi kết quả để nhận toàn bộ ký tự trùng
							ketQua += chuoiDau;
						} else {
							chuoiDau = ""; // Làm mới chuỗi đầu để nhận ký tự tiếp theo
						}
					}
					dau++;
					sau++;
				}
			}
			if (kq == "") {
				kq += ketQua;
			} else if (kq.contains(ketQua)) {
				if (ketQua.length() < kq.length()) {
					kq = ketQua;
				}
				continue out;
			}

		}
		System.out.println(kq);
	}
}

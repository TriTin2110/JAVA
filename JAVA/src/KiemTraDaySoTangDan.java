import java.util.Scanner;

class KiemTraDaySoTangDan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int soNguyenDuong = 0;
		boolean check = true;

		// Nhập số nguyên dương
		do {
			try {
				System.out.println("Hãy nhập 1 số nguyên dương bất kỳ: ");
				soNguyenDuong = sc.nextInt();
				check = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số nguyên dương bạn nhập vào không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		outPut(soNguyenDuong);
		sc.close();
	}

	static void outPut(int soNguyenDuong) {
		// chia lần lượt cho 10
		// lưu phần dư của số vừa chia được vào số trung gian
		// So sánh số trung gian và phần dư của số tiếp theo
		boolean kiemTraKetQua = true;
		int soTrungGian = soNguyenDuong % 10;
		soNguyenDuong /= 10;
		while (soNguyenDuong > 0) {
			if ((soNguyenDuong / 10) != 0) {
				if (soTrungGian < (soNguyenDuong % 10)) {
					kiemTraKetQua = false;
					break;
				}
			} else {
				if (soTrungGian < soNguyenDuong) {
					kiemTraKetQua = false;
					break;
				}
			}
			soTrungGian = soNguyenDuong % 10;
			soNguyenDuong /= 10;
		}

		System.out.println((kiemTraKetQua == true) ? "Số vừa nhập là số có thứ tự tăng dần"
				: "Số vừa nhập không thỏa mãn điều kiện tăng dần");
	}
}

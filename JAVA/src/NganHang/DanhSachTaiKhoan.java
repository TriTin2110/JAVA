package NganHang;

import java.util.ArrayList;

class DanhSachTaiKhoan {
	ArrayList<Account> ac;
	int i = 0;

	public DanhSachTaiKhoan() {
		ac = new ArrayList<Account>();
	}

	boolean kiemTraTaiKhoan(Account anotherAccount) {

		if (ac.contains(anotherAccount)) {
			i = 0;
			return true;
		} else {
			i++;
			System.out.println("Tài khoản không hợp lệ!");
			if (i == 3) {
				System.out.println("Tài khoản của bạn đã bị khóa!");
				// Thoát khỏi chương trình
				System.exit(0);
			}
			return false;
		}
	}

	// In thông tin tài khoản
	void inThongTinTaiKhoan(Account inAccount) {
		if (kiemTraTaiKhoan(inAccount)) {
			System.out.println(ac.get(ac.indexOf(inAccount)).toString());
		}
	}

	void themTaiKhoan(Account a) {
		ac.add(a);
	}

	// Khóa tài khoản
	void khoaTaiKhoan(Account a) {
		ac.get(ac.indexOf(a)).setSoTaiKhoan(0);
	}

	// Nạp tiền vào tài khoản
	void napTienVaoTaiKhoan(Account anotherAccount, double tienNap) {
		if (kiemTraTaiKhoan(anotherAccount)) {
			int viTri = ac.indexOf(anotherAccount);
			ac.get(viTri).setSoTienTaiKhoan(ac.get(viTri).getSoTienTaiKhoan() + tienNap);
		}
	}

	// Rút tiền ra khỏi tài khoản
	void rutTien(Account anotherAccount, double tienRut) {
		if (kiemTraTaiKhoan(anotherAccount)) {
			int viTri = ac.indexOf(anotherAccount);
			if (kiemTraTienRut(anotherAccount, tienRut)) {
				ac.get(viTri).setSoTienTaiKhoan(ac.get(viTri).getSoTienTaiKhoan() - tienRut);
			} else {
				System.out.println("Số tiền rút lớn hơn số tiền hiện có trong tài khoản");
			}
		}
	}

	// Kiểm tra số tiền rút gửi
	boolean kiemTraTienRut(Account anotherAccount, double tienRut) {
		int viTri = ac.indexOf(anotherAccount);
		if (tienRut <= ac.get(viTri).getSoTienTaiKhoan()) {
			return true;
		} else {
			return false;
		}
	}

	// Đáo hạn
	void daoHan(Account anotherAccount) {
		if (kiemTraTaiKhoan(anotherAccount)) {
			int viTri = ac.indexOf(anotherAccount);
			double soTienTrongTaiKhoan = ac.get(viTri).getSoTienTaiKhoan();
			soTienTrongTaiKhoan += soTienTrongTaiKhoan * ac.get(ac.indexOf(anotherAccount)).getLaiSuat();
			ac.get(viTri).setSoTienTaiKhoan(soTienTrongTaiKhoan);
		}
	}

	// Chuyển tiền
	void chuyenTien(Account anotherAccount, Account guestAccount, double tienGui, double tienNhan) {
		if (kiemTraTaiKhoan(anotherAccount)) {
			if (kiemTraTienRut(anotherAccount, tienGui)) {
				rutTien(anotherAccount, tienGui);
				napTienVaoTaiKhoan(guestAccount, tienNhan);
			} else {
				System.out.println("Số tiền gửi không hợp lệ!");
			}
		}
	}
}

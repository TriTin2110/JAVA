package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;
import Model.dangNhapModel;
import View.KhungDangNhap;
import View.taoTaiKhoan;

public class ControllerChuongTrinhDangNhap implements ActionListener {
	KhungDangNhap khungDangNhap;
	taoTaiKhoan taoTaiKhoan;

	public ControllerChuongTrinhDangNhap(KhungDangNhap khungDangNhap) {
		this.khungDangNhap = khungDangNhap;
	}

	public ControllerChuongTrinhDangNhap(taoTaiKhoan taoTaiKhoan) {
		this.taoTaiKhoan = taoTaiKhoan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Tạo tài khoản mới": {
			khungDangNhap.setVisible(false);
			new taoTaiKhoan();
			break;
		}
		case "Ok": {
			dangNhap();
			break;
		}

		case "Create": {
			// Nằm trong controller
			taoTaiKhoan();
			break;
		}
		case "Cancel": {
			taoTaiKhoan.setVisible(false);
			new KhungDangNhap();
			break;
		}
		case "Exit": {
			System.exit(0);
		}
		}
	}

	private boolean timKiemTaiKhoan(String taiKhoan, String matKhau) {
		boolean check = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from dangNhapModel");
		List<dangNhapModel> list = query.getResultList();
		// Tạo tài khoản mới
		if (matKhau == "") {
			out: for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getTaiKhoan().equals(taiKhoan)) {
					// Trường hợp tồn tại tài khoản trong db
					check = true;
					break out;
				}
			}
		}

		// Đăng nhập
		else {
			out: for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getTaiKhoan().equals(taiKhoan)) {
					// Trường hợp tồn tại tài khoản trong db
					if (list.get(i).getMatKhau().equals(matKhau)) {
						khungDangNhap.setVisible(false);
						check = true;
						break out;
					}
				}
			}
		}

		return check;
	}

	private void thongBao(String noiDung) {
		JOptionPane.showMessageDialog(khungDangNhap, noiDung, "Thông báo", JOptionPane.PLAIN_MESSAGE);
	}

	private void dangNhap() {
		String taiKhoan = khungDangNhap.textUser.getText();
		String matKhau = khungDangNhap.textPassword.getText();
		if (timKiemTaiKhoan(taiKhoan, matKhau)) {
			thongBao("Đăng nhập thành công!");
		} else {
			thongBao("Đăng nhập KHÔNG thành công vui lòng kiểm tra lại tài khoản hoặc mật khẩu");
		}
	}

	private void taoTaiKhoan() {
		String taiKhoan = taoTaiKhoan.textUser.getText();
		String matKhau = taoTaiKhoan.passwordPassword.getText();

		// Nếu 2 mật khẩu trùng nhau và tài khoản không tồn tại trong db
		if (matKhau.equals(taoTaiKhoan.passwordConfirmPassword.getText()) && !timKiemTaiKhoan(taiKhoan, "")) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			dangNhapModel dangNhapModel = new dangNhapModel(taiKhoan, matKhau);
			session.getTransaction().begin();
			session.save(dangNhapModel);
			session.getTransaction().commit();
			session.close();
			thongBao("Tạo tài khoản thành công!");
			taoTaiKhoan.setVisible(false);
			new KhungDangNhap();
		} else {
			if (!matKhau.equals(taoTaiKhoan.passwordConfirmPassword.getText())) {
				thongBao("Mật khẩu không trùng khớp!");
			} else {
				thongBao("Tài khoản này đã tồn tại!");
			}
		}
	}
}

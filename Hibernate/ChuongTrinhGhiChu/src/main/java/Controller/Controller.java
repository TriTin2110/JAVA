package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;
import View.ViewGhiChu;
import View.viewDangKy;
import View.viewDangNhap;
import model.modelTaiKhoan;

public class Controller implements ActionListener {
	viewDangNhap viewDangNhap;
	viewDangKy viewDangKy;
	ViewGhiChu viewGhiChu;
	modelTaiKhoan modelTaiKhoan = null;

	public Controller(ViewGhiChu viewGhiChu) {
		this.viewGhiChu = viewGhiChu;
	}

	public Controller(viewDangNhap viewDangNhap) {
		this.viewDangNhap = viewDangNhap;
	}

	public Controller(viewDangKy viewDangKy) {
		this.viewDangKy = viewDangKy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		modelTaiKhoan doiTuongTrongDB = null;
		// TODO Auto-generated method stub
		ViewGhiChu viewGhiChu = null;
		String lenh = e.getActionCommand();
		int loaiThongBao = 0;
		String thongBao;
		boolean kiemTra;
		switch (lenh) {
		case "Đăng nhập": {
			// Kiểm tra tính hợp lệ của tài khoản và mật khẩu của người dùng nhập vào
			kiemTra = kiemTraTaiKhoanVaMatKhau(this.viewDangNhap.textFieldTaiKhoan.getText(),
					this.viewDangNhap.fieldMatKhau.getText());
			// Trường hợp taiKhoan hoặc matKhau của ng dùng nhập thiếu
			// Sẽ trả về false và thông báo cho ng dùng
			if (!kiemTra)
				loaiThongBao = 0;
			else {
				// Nếu phương thức tìm kiểm trả về đối tượng có trong danh sách thì kiemTra =
				// true
				doiTuongTrongDB = timKiemTaiKhoan(viewDangNhap.textFieldTaiKhoan.getText());

				kiemTra = (doiTuongTrongDB == null) ? false : true;
				// Kiểm tra mật khẩu
				if (kiemTra) {
					loaiThongBao = viewDangNhap.kiemTraMatKhau(doiTuongTrongDB.getMatKhau());
					// Mỗi lần đăng ký sẽ tạo 1 ghiChuMoi
					// mục tiêu là mỗi lần đăng nhập thì sẽ mở ghi chú đã đóng gần nhất
					if (loaiThongBao == 0) {
						thongBao(loaiThongBao, "Đăng nhập không thành công!", viewGhiChu);
					} else {
						viewGhiChu = new ViewGhiChu();
						// Tiến hành cập nhật ndung theo tài khoản người dùng
						viewGhiChu.layNoiDung(doiTuongTrongDB);
						thongBao(loaiThongBao, "Đăng nhập thành công!", viewDangKy);
						viewDangNhap.dispose();
					}
				} else {
					thongBao(loaiThongBao, "Đăng nhập không thành công!", viewGhiChu);
				}
			}
			break;
		}

		case "Đăng ký": {
			viewDangNhap.setVisible(false);
			new viewDangKy();
			break;
		}

		case "Tạo tài khoản mới!": {
			// Kiểm tra tài khoản tồn tại trong db (trả về null -> chưa tồn tại)
			kiemTra = (timKiemTaiKhoan(viewDangKy.textFieldTaiKhoanMoi.getText()) == null) ? true : false;
			modelTaiKhoan modelTaiKhoan = viewDangKy.dangKy(kiemTra);
			// Đăng ký tài khoản vào db
			// viewDangKy.dangKy(kiemTra) -> Đối tượng đăng ký
			// Xác định loại thông báo

			loaiThongBao = (modelTaiKhoan == null) ? 0 : 1;
			// Đặt nội dun thông báo
			thongBao = (loaiThongBao == 0) ? "Tạo tài khoản không thành công!" : "Tạo tài khoản thành công";
			thongBao(loaiThongBao, thongBao, viewDangKy);
			// Nếu đăng ký thành công thì sẽ đóng cửa sổ tạo tài khoản và mở cửa sổ đăng
			// nhập
			if (loaiThongBao == 1) {
				viewDangKy.dispose();
				viewGhiChu = new ViewGhiChu();
//				Ẩn cửa sổ ghi chú để ng dùng tiến hành đăng nhập trc
				viewGhiChu.setVisible(false);
//				Tạo ghi chú mới cho tài khoản vừa đăng ký thành công
				viewGhiChu.themGhiChuMoi(modelTaiKhoan);
				new viewDangNhap();
			}
			break;
		}

		case "Lưu ghi chú":
			this.viewGhiChu.luuNoiDung();
			this.viewGhiChu.luuFile();
			break;

		case "Mở ghi chú":
			this.viewGhiChu.docFile();
			break;

		case "Xóa ghi chú":
			this.viewGhiChu.xoaFile();
		}
	}

	// Tìm kiếm tài khoản dựa vào taiKhoan người dùng
	public modelTaiKhoan timKiemTaiKhoan(String taiKhoan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from modelTaiKhoan");
		List<modelTaiKhoan> list = query.getResultList();
		session.close();
		// Đăng ký
		// Điều kiện: Tài khoản chưa có trong db
		for (int i = 0; i < list.size(); i++) {
			if (taiKhoan.equals(list.get(i).getTaiKhoan())) {
				return list.get(i);
			}

		}
		return null;
	}

	// Hiển thị thông báo khi đăng nhập
	private void thongBao(int loaiThongBao, String thongBao, Component component) {
		JOptionPane.showMessageDialog(component, thongBao, "Thông báo", loaiThongBao);
	}

	// Kiểm tra tính hợp lệ của tài khoản và mật khẩu
	public boolean kiemTraTaiKhoanVaMatKhau(String taiKhoan, String matKhau) {
		taiKhoan.trim();
		matKhau.trim();
		if (matKhau.equals("") || taiKhoan.equals(""))
			return false;
		return true;
	}

}
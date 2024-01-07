package QuanLySinhVienGiaoDien.QuanLySinhVienController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import QuanLySinhVienGiaoDien.QuanLySinhVienModel.QueQuan;
import QuanLySinhVienGiaoDien.QuanLySinhVienModel.SinhVien;
import QuanLySinhVienGiaoDien.QuanLySinhVienView.ViewSinhVien;

public class ControllerSinhVien implements ActionListener {
	ViewSinhVien viewSinhVien;
	int maSinhVien = 0;

	public ControllerSinhVien(ViewSinhVien viewSinhVien) {
		this.viewSinhVien = viewSinhVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		int row = this.viewSinhVien.table.getSelectedRow();
		switch (luaChon) {
		case "Thêm":
			this.viewSinhVien.danhSachSinhVien.setLuaChon(luaChon);
			this.viewSinhVien.xoaDuLieuThongTin();
			break;

		case "Lưu":

			if (this.viewSinhVien.kiemTraThongTinRong()) {
				JOptionPane.showMessageDialog(this.viewSinhVien, "Dữ liệu thông tin đang rỗng!");
			} else {
				// Lấy thông tin sinh viên
				if (this.viewSinhVien.danhSachSinhVien.getLuaChon().equals("Thêm")
						|| this.viewSinhVien.danhSachSinhVien.luaChon.equals("")) {
					layThongTinSinhVien();
					this.viewSinhVien.xoaDuLieuThongTin();
				} else if (this.viewSinhVien.danhSachSinhVien.getLuaChon().equals("Cập nhật")) {
					// Nếu cập nhật thì tạo ra đối tượng sinh viên mới và gọi hàm
					// themSinhVien(sinhVien)
					this.viewSinhVien.themSinhVien(layThongTinSinhVien());
				}
			}
			break;

		case "Cập nhật":

			row = this.viewSinhVien.table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this.viewSinhVien, "Bạn chưa chọn sinh viên!");
			} else {
				this.viewSinhVien.xoaDuLieuThongTin();
				this.viewSinhVien.danhSachSinhVien.setLuaChon(luaChon);
				maSinhVien = layThongTinDeCapNhat().getMaSinhVien();
			}

			break;
		case "Xóa":
			row = this.viewSinhVien.table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this.viewSinhVien, "Bạn chưa chọn sinh viên!");
			} else {
				this.viewSinhVien.danhSachSinhVien.setLuaChon("");
				this.viewSinhVien.xoaDongDuLieu(layThongTinDeCapNhat());
				this.viewSinhVien.xoaDuLieuThongTin();
			}
			break;

		case "Lọc sinh viên":
			this.viewSinhVien.locSinhVien();
			break;
		case "Hủy":
			this.viewSinhVien.huyLoc();
			break;
		case "Mở":
			this.viewSinhVien.moFile();
			break;
		case "Lưu File":
			this.viewSinhVien.luuFile();
			JOptionPane.showMessageDialog(this.viewSinhVien, "Nội dung đã được lưu!");
			break;
		case "Về chúng tôi":
			JOptionPane.showMessageDialog(this.viewSinhVien, "Chào mừng bạn đến với chương trình quản lý sinh viên!");
			break;
		case "Thoát", "Hủy bỏ":
			System.exit(0);
		}
	}

	public SinhVien layThongTinSinhVien() {
		SinhVien sv = null;
		String maSinhVienDauVao = this.viewSinhVien.textFieldMaSinhVien.getText();
		String diem1DauVao = this.viewSinhVien.textFieldMon1.getText();
		String diem2DauVao = this.viewSinhVien.textFieldMon2.getText();
		String diem3DauVao = this.viewSinhVien.textFieldMon3.getText();
		if (kiemTraDuLieuNhapVao(maSinhVienDauVao, diem1DauVao, diem2DauVao, diem3DauVao)) {
			JOptionPane.showMessageDialog(this.viewSinhVien, "Dữ liệu đầu vào không hợp lệ!");
		} else {
			int maSinhVien = Integer.valueOf(this.viewSinhVien.textFieldMaSinhVien.getText());
			String hoTen = this.viewSinhVien.textFieldHoTen.getText();
			String ngaySinh = this.viewSinhVien.textFieldNgaySinh.getText();
			boolean gioiTinh = true;
			if (this.viewSinhVien.rdbtnNam.isSelected()) {
				gioiTinh = true;
			} else {
				gioiTinh = false;
			}
			int maTinh = this.viewSinhVien.comboBoxQueQuan.getSelectedIndex();
			QueQuan queQuan = QueQuan.getID(maTinh);
			Float diem1 = Float.valueOf(this.viewSinhVien.textFieldMon1.getText());
			Float diem2 = Float.valueOf(this.viewSinhVien.textFieldMon2.getText());
			Float diem3 = Float.valueOf(this.viewSinhVien.textFieldMon3.getText());
			sv = new SinhVien(hoTen, ngaySinh, maSinhVien, gioiTinh, diem1, diem2, diem3, queQuan);
			boolean luaChon = this.viewSinhVien.danhSachSinhVien.getLuaChon().equals("Cập nhật");
			boolean daTonTai = this.viewSinhVien.danhSachSinhVien.kiemTraSinhVienCoTonTaiTrongDanhSach(sv);
			if (daTonTai && !luaChon) {
				JOptionPane.showMessageDialog(this.viewSinhVien, "Sinh viên đã tồn tại trong danh sách", "Lỗi!!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (luaChon) {
					this.viewSinhVien.danhSachSinhVien.capNhatSinhVien(sv);
				}
				this.viewSinhVien.themSinhVien(sv);
			}
		}

		return sv;
	}

	public SinhVien layThongTinDeCapNhat() {
		int rowSelected = this.viewSinhVien.table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) this.viewSinhVien.table.getModel();
		int maSinhVien = Integer.valueOf(model.getValueAt(rowSelected, 0) + "");
		this.viewSinhVien.textFieldMaSinhVien.setText(maSinhVien + "");
		String hoTen = model.getValueAt(rowSelected, 1) + "";
		this.viewSinhVien.textFieldHoTen.setText(hoTen);
		String tenQueQuan = model.getValueAt(rowSelected, 2) + "";
		QueQuan queQuan = QueQuan.getID(tenQueQuan);
		this.viewSinhVien.comboBoxQueQuan.setSelectedItem(tenQueQuan + "");
		String ngaySinh = model.getValueAt(rowSelected, 3) + "";
		this.viewSinhVien.textFieldNgaySinh.setText(ngaySinh);
		boolean gioiTinh = ((model.getValueAt(rowSelected, 4) + "").equals("Nam")) ? true : false;
		if ((model.getValueAt(rowSelected, 4) + "").equals("Nam")) {
			this.viewSinhVien.rdbtnNam.setSelected(true);
		} else {
			this.viewSinhVien.rdbtnNu.setSelected(true);
		}
		Float diem1 = Float.valueOf(model.getValueAt(rowSelected, 5) + "");
		this.viewSinhVien.textFieldMon1.setText(diem1 + "");
		Float diem2 = Float.valueOf(model.getValueAt(rowSelected, 6) + "");
		this.viewSinhVien.textFieldMon2.setText(diem2 + "");
		Float diem3 = Float.valueOf(model.getValueAt(rowSelected, 7) + "");
		this.viewSinhVien.textFieldMon3.setText(diem3 + "");
		SinhVien sinhVien = new SinhVien(hoTen, ngaySinh, maSinhVien, gioiTinh, diem1, diem2, diem3, queQuan);
		return sinhVien;
	}

	public boolean kiemTraDuLieuNhapVao(String maSinhVien, String diem1, String diem2, String diem3) {
		Pattern pattern = Pattern.compile("[a-z]|[A-Z]");
		Matcher matcherMaSinhVien = pattern.matcher(maSinhVien);
		Matcher matcherdiem1 = pattern.matcher(diem1);
		Matcher matcherdiem2 = pattern.matcher(diem2);
		Matcher matcherdiem3 = pattern.matcher(diem3);
		boolean kiemTra = false;
		if (matcherMaSinhVien.find() || matcherdiem1.find() || matcherdiem2.find() || matcherdiem3.find()) {
			kiemTra = true;
		}
		return kiemTra;
	}

}

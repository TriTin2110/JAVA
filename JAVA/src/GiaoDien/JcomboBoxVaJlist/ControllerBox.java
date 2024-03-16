package GiaoDien.JcomboBoxVaJlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

class ControllerBox implements ActionListener {
	ViewBox viewBox;

	public ControllerBox(ViewBox viewBox) {
		this.viewBox = viewBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String monChinh = this.viewBox.jComboBox.getSelectedItem().toString();

		String monPhu = "";
		Object[] obj = this.viewBox.jListMonPhu.getSelectedValuesList().toArray();
		for (Object object : obj) {
			monPhu += object + ";";
		}

		this.viewBox.modelBox.setMonChinh(monChinh);
		this.viewBox.modelBox.setMonPhu(monPhu);
		this.viewBox.modelBox.tinhTongTienMonChinh();
		this.viewBox.modelBox.tinhTongTienMonPhu();
		this.viewBox.hienThiKetQua();
		xuatThongBao();
	}

	void xuatThongBao() {
		String soTienThongBao = JOptionPane.showInputDialog(this.viewBox, "Hãy nhập số tiền trả:",
				"Thông báo tính tiền", JOptionPane.PLAIN_MESSAGE);

		try {

			double soTien = Integer.valueOf(soTienThongBao);
			double tongTienMonChinh = this.viewBox.modelBox.getTongTienMonChinh();
			double tongTienMonPhu = this.viewBox.modelBox.getTongTienMonPhu();
			if (soTien >= (tongTienMonChinh + tongTienMonPhu)) {
				JOptionPane.showConfirmDialog(this.viewBox, "Đã thanh toán thành công!", "Thông báo tính tiền",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.viewBox, "Số tiền không đủ!", "Thông báo tính tiền",
						JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this.viewBox, "Số tiền nhập vào không hợp lệ", "Thông báo lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}

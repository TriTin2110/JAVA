package GiaoDien.CheckBoxAndRadioBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

class ControllerBox implements ActionListener {
	ViewBox viewBox;

	public ControllerBox(ViewBox viewBox) {
		this.viewBox = viewBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String monChinh = "";
		// Lấy tất cả các thành phần có trong grpMonChinh
		// Duyệt từng thành phần và đặt giá trị button = các thành đó
		// Nếu button được chọn ở giá trị nào thì monChinh sẽ bằng giá trị đó
		Enumeration<AbstractButton> monChinhButton = viewBox.buttonGroupMonChinh.getElements();
		while (monChinhButton.hasMoreElements()) {
			AbstractButton button = monChinhButton.nextElement();
			if (button.isSelected()) {
				monChinh = button.getText();
			}
		}

		String monPhu = "";
//		Lấy tất cả các thành phần có trong Arraylist monPhu
		ArrayList<JCheckBox> checkBoxMonPhu = this.viewBox.jCheckBoxs;
		for (AbstractButton button : checkBoxMonPhu) {
			if (button.isSelected()) {
				monPhu += button.getText() + ";";
			}
		}

		this.viewBox.modelBox.setMonChinh(monChinh);
		this.viewBox.modelBox.setMonPhu(monPhu);
		this.viewBox.modelBox.tinhTongTienMonChinh();
		this.viewBox.modelBox.tinhTongTienMonPhu();
		String thanhToan = e.getActionCommand();
		if (thanhToan.equals("Thanh toán")) {
			this.viewBox.hienThiKetQua();
		}
	}

}

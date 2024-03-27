package PhuongTrinhBacHaiGiaoDien.controllerBac2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PhuongTrinhBacHaiGiaoDien.viewBac2.viewBac2;

public class ControllerBac2 implements ActionListener {
	viewBac2 viewBac2;

	public ControllerBac2(viewBac2 viewBac2) {
		this.viewBac2 = viewBac2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		switch (luaChon) {
		case "Giải":
			this.viewBac2.hienThiKetQua();
			break;

		case "Xóa rỗng":
			this.viewBac2.resetGiaTri();
			break;

		case "Thoát":
			System.exit(0);
			break;
		}

	}

}

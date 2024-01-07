package NguyenToSwing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import NguyenToSwing.view.viewNguyento;

public class controllerNguyenToSwing implements ActionListener {
	viewNguyento viewNguyento;

	public controllerNguyenToSwing(NguyenToSwing.view.viewNguyento viewNguyento) {
		this.viewNguyento = viewNguyento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		if (luaChon == "Generate") {
			this.viewNguyento.hienThiKetQua();
		}
	}

}

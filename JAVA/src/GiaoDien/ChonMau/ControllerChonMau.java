package GiaoDien.ChonMau;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControllerChonMau implements ActionListener {
	ViewChonMau viewChonMau;

	public ControllerChonMau(ViewChonMau viewChonMau) {
		this.viewChonMau = viewChonMau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();

		switch (luaChon) {
		case "Red Text":
			this.viewChonMau.changeTextColor(Color.red);
			break;

		case "Yellow Text":
			this.viewChonMau.changeTextColor(Color.yellow);
			break;

		case "Green Text":
			this.viewChonMau.changeTextColor(Color.green);
			break;

		case "Red Background":
			this.viewChonMau.changeBackgroundColor(Color.red);
			break;

		case "Yellow Background":
			this.viewChonMau.changeBackgroundColor(Color.yellow);
			break;

		case "Green Background":
			this.viewChonMau.changeBackgroundColor(Color.green);
			break;
		}
	}

}

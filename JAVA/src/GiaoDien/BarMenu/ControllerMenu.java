package GiaoDien.BarMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMenu implements ActionListener {
	ViewMenu viewMenu;

	public ControllerMenu(ViewMenu viewMenu) {
		this.viewMenu = viewMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		switch (src) {
		case "Mở":
			this.viewMenu.xuLyLuaChon(src);
			break;
		case "Thoát":
			System.exit(0);
			break;
		case "Giới thiệu":
			this.viewMenu.xuLyLuaChon(src);
			break;
		}
	}

}

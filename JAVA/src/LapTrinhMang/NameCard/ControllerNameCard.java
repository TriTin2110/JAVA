package LapTrinhMang.NameCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerNameCard implements ActionListener {
	ViewNameCard viewNameCard;

	public ControllerNameCard(ViewNameCard viewNameCard) {
		this.viewNameCard = viewNameCard;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Lưu danh thiếp":
			this.viewNameCard.setDanhThiep();
			break;

		case "Nhập danh thiếp":
			this.viewNameCard.read();
			break;

		case "Chọn ảnh":
			this.viewNameCard.showPic();
			break;
		}
	}

}

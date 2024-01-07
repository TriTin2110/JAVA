package ChuongTrinhDemSo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControllerDemSo implements ActionListener {
	private ViewDemSo viewDemSo;

	public ControllerDemSo(ViewDemSo viewDemSo) {
		this.viewDemSo = viewDemSo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();

		if (src.equals("Tăng")) {
			this.viewDemSo.tang();
		} else if (src.equals("Giảm")) {
			this.viewDemSo.giam();
		} else {
			this.viewDemSo.reset();
		}
	}

}

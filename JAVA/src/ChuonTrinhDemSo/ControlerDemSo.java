package ChuonTrinhDemSo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlerDemSo implements ActionListener {
	private ViewDemSo viewDemSo;

	public ControlerDemSo(ViewDemSo viewDemSo) {
		// TODO Auto-generated constructor stub
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

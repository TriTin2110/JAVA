package GiaoDien.ThucHienPhepToan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThucHienPhepToanController implements ActionListener {
	ThucHienPhepToanView thucHienPhepToanView;

	public ThucHienPhepToanController(ThucHienPhepToanView thucHienPhepToanView) {
		this.thucHienPhepToanView = thucHienPhepToanView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		switch (luaChon) {
		case "+":
			this.thucHienPhepToanView.phepCong();
			break;
		case "-":
			this.thucHienPhepToanView.phepTru();
			break;
		case "*":
			this.thucHienPhepToanView.phepNhan();
			break;
		case "/":
			this.thucHienPhepToanView.phepChia();
			break;
		case "^":
			this.thucHienPhepToanView.phepMu();
			break;
		case "%":
			this.thucHienPhepToanView.phepChiaDu();
			break;
		}
	}

}

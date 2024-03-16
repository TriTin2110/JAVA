package GiaoDien.TimTuKhoaTrongVanBan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerTimTuKhoa implements ActionListener {
	ViewTimTuKhoa viewTimTuKhoa;

	public ControllerTimTuKhoa(ViewTimTuKhoa viewTimTuKhoa) {
		this.viewTimTuKhoa = viewTimTuKhoa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.viewTimTuKhoa.timTuKhoa();
	}

}

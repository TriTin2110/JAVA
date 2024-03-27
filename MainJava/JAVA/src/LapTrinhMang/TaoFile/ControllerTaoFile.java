package LapTrinhMang.TaoFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerTaoFile implements ActionListener {
	ViewTaoFile viewTaoFile;

	public ControllerTaoFile(ViewTaoFile viewTaoFile) {
		this.viewTaoFile = viewTaoFile;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Choose":
			viewTaoFile.openFolder();
			break;

		case "Create":
			viewTaoFile.createFile();
			break;
		}

	}

}

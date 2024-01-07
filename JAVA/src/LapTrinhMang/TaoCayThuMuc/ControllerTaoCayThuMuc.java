package LapTrinhMang.TaoCayThuMuc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControllerTaoCayThuMuc implements ActionListener {
	TaoCayThuMuc taoCayThuMuc;

	public ControllerTaoCayThuMuc(TaoCayThuMuc taoCayThuMuc) {
		this.taoCayThuMuc = taoCayThuMuc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Find":
			taoCayThuMuc.findingFile();
			break;
		case "Delete":
			int option = JOptionPane.showConfirmDialog(taoCayThuMuc, "Bạn có chắc là muốn xóa chứ?");
			if (option == JOptionPane.NO_OPTION)
				return;
			taoCayThuMuc.deletingFile(taoCayThuMuc.jTextFieldFile.getText());
			JOptionPane.showMessageDialog(taoCayThuMuc, "Đã xóa thành công!");
			break;
		case "Rename":
			taoCayThuMuc.renameFile(taoCayThuMuc.jTextFieldFile.getText());
			break;
		case "Copy":
			taoCayThuMuc.copyFile();
			break;
		case "File Log":
			taoCayThuMuc.docFileLog();
			break;
		}
	}

}

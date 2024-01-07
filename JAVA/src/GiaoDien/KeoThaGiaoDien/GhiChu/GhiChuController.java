package GiaoDien.KeoThaGiaoDien.GhiChu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

class GhiChuController implements ActionListener {
	GhiChuView ghiChuView;

	public GhiChuController(GhiChuView ghiChuView) {
		this.ghiChuView = ghiChuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		JFileChooser jFileChooser = new JFileChooser();
		switch (luaChon) {
		case "Mở":
			int returnFile = jFileChooser.showOpenDialog(this.ghiChuView);
			if (returnFile == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				this.ghiChuView.ghiChuModel.setDuongDan(file.getAbsolutePath());
				String ketQua = "";
				try {
					List<String> noiDung = Files.readAllLines(file.toPath());
					for (String string : noiDung) {
						ketQua += string;
						ketQua += "\n";
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				this.ghiChuView.textArea.setText(ketQua);
			}
			break;

		case "Lưu":
			if (this.ghiChuView.ghiChuModel.getDuongDan().length() > 0) {
				ghiDuLieu(new File(this.ghiChuView.ghiChuModel.getDuongDan()));
			} else {
				int saveFile = jFileChooser.showSaveDialog(this.ghiChuView);
				if (saveFile == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					ghiDuLieu(file);
				}
			}

		}
	}

	void ghiDuLieu(File file) {
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.write(this.ghiChuView.textArea.getText());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

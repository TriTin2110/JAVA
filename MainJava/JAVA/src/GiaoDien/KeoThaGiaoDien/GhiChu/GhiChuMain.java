package GiaoDien.KeoThaGiaoDien.GhiChu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class GhiChuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GhiChuView();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
		}

	}

}

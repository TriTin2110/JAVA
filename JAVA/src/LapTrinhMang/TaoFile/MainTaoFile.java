package LapTrinhMang.TaoFile;

import javax.swing.UIManager;

public class MainTaoFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViewTaoFile();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

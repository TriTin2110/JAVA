package MyClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import Model.ModelAuthor;
import main.ClientMainFrame;

public class ReadingBackup {
	public static ArrayList<ModelAuthor> readAuthorBackup(ClientMainFrame clientMainFrame) {
		ArrayList<ModelAuthor> list = new ArrayList<ModelAuthor>();
		try {
			JFileChooser jFileChooser = new JFileChooser();
			int result = jFileChooser.showOpenDialog(clientMainFrame);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				ModelAuthor modelAuthor = null;
				Object re = null;
				while ((re = ois.readObject()) != null) {
					modelAuthor = (ModelAuthor) re;
					list.add(modelAuthor);
				}
				ois.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

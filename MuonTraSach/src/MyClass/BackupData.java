package MyClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import Controller.CreateTable;
import Interface.MainInterface;
import Model.ModelAuthor;
import Model.ModelBook;
import Model.ModelStudent;
import main.ClientMainFrame;

public class BackupData {
	public static void BackupData(ClientMainFrame clientMainFrame) {
		try {
			MainInterface mainInterface = (MainInterface) Naming.lookup("rmi://localhost:1026/test");
			ArrayList<Object> list = mainInterface.printList(clientMainFrame.tableChosen);
			JFileChooser jFileChooser = new JFileChooser();
			int result = jFileChooser.showSaveDialog(clientMainFrame);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				for (Object object : list) {
					oos.writeObject(object);
				}
				oos.flush();
				oos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void ImportData(ClientMainFrame clientMainFrame) {
		// Đọc file lên trước
		// Phân loại file thông qua instanceOf
		// truncate toàn bộ dữ liệu hiện tại
		// add dữ liệu từ file vào
		// in ra bảng mới

		ArrayList<Object> list = new ArrayList<Object>();
		try {
			JFileChooser jFileChooser = new JFileChooser();
			int result = jFileChooser.showOpenDialog(clientMainFrame);

			if (result == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				Object object = new Object();
				while (true) {
					object = (Object) ois.readObject();
					if (object == null)
						break;
					list.add(object);
				}
				ois.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			checkingImportData(list, clientMainFrame);
		}

	}

	public static void checkingImportData(ArrayList<Object> list, ClientMainFrame clientMainFrame) {
		CreateTable createTable = new CreateTable();
		MainInterface mainInterface = null;
		try {
			mainInterface = (MainInterface) Naming.lookup("rmi://localhost:1026/test");

			if (list.get(0) instanceof ModelAuthor) {
				createTable.getListAuthor(clientMainFrame, list);
			} else if (list.get(0) instanceof ModelStudent) {
				createTable.getListStudent(clientMainFrame, list);
			} else if (list.get(0) instanceof ModelBook) {
				createTable.getListBook(clientMainFrame, list);
			} else {
				createTable.getListBorrow(clientMainFrame, list, mainInterface);
			}
			for (Object object : list) {
				if (mainInterface.searching(object, clientMainFrame.tableChosen) == null) {
					mainInterface.add(object, clientMainFrame.tableChosen);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package LapTrinhMang.QuanLySanPham.Controller;

import java.util.ArrayList;

import LapTrinhMang.QuanLySanPham.Implement.MainImplement;
import LapTrinhMang.QuanLySanPham.Interface.MainInterface;
import LapTrinhMang.QuanLySanPham.Model.ModelCompany;
import LapTrinhMang.QuanLySanPham.Model.ModelProduct;
import LapTrinhMang.QuanLySanPham.MyClass.CheckingData;

public class MainController {
	public void chose(String[] command) {
		MainInterface mainInterface = new MainImplement();
		switch (command[0]) {
		case "Thêm":
			// ToDo
			add(command, mainInterface);
			break;

		case "Xóa":
			// ToDo
			remove(command, mainInterface);
			break;

		case "Sửa":
			// ToDo
			update(command, mainInterface);
			break;

		case "Tìm":
			// ToDo
			searching(command, mainInterface);
			break;

		case "InDS":
			// ToDo
			printList(command, mainInterface);
			break;
		}
	}

	public void add(String[] command, MainInterface mainInterface) {
		Object object = null;
		if (command[1].equals("Company")) {
			object = new ModelCompany(command[2], command[3], command[4]);
		} else {
			object = new ModelProduct(command[2], command[3], Long.parseLong(command[4]), command[5]);
		}
		if (CheckingData.checkingPrimary(object)) {
			mainInterface.add(object);
		} else {
			System.out.println("Id đã tồn tại trong danh sách");
		}
	}

	public void remove(String[] command, MainInterface mainInterface) {
		if (command[1].equals("Company")) {
			ModelCompany modelCompany = new ModelCompany(command[2]);
			if (!CheckingData.checkingPrimary(modelCompany)) {
				mainInterface.remove(modelCompany);
			} else {
				System.out.println("Id không tồn tại trong danh sách");
			}
		} else {
			ModelProduct modelProduct = new ModelProduct(command[2]);
			if (!CheckingData.checkingPrimary(modelProduct)) {
				mainInterface.remove(modelProduct);
			} else {
				System.out.println("Id không tồn tại trong danh sách");
			}
		}
	}

	public void update(String[] command, MainInterface mainInterface) {
		if (command[1].equals("Company")) {
			ModelCompany modelCompany = new ModelCompany(command[2], command[3], command[4]);
			if (!CheckingData.checkingPrimary(modelCompany)) {
				mainInterface.update(modelCompany);
			} else {
				System.out.println("Id không tồn tại trong danh sách");
			}
		}
	}

	public void searching(String[] command, MainInterface mainInterface) {
		if (command[1].equals("Company")) {
			ModelCompany modelCompany = (ModelCompany) mainInterface.searching(new ModelCompany(command[2]));
			if (modelCompany == null) {
				System.out.println("Id không tồn tại trong danh sách");
			} else {
				System.out.println(modelCompany.toString());
			}
		}
	}

	public void printList(String[] command, MainInterface mainInterface) {
		if (command[1].equals("Company")) {
			ArrayList<Object> list = mainInterface.printList(command[1]);
			for (Object object : list) {
				ModelCompany modelCompany = (ModelCompany) object;
				System.out.println(modelCompany.toString());
			}
		}
	}
}

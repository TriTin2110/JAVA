package main;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import Controller.MainController;
import Implements.MainImp;
import Interface.MainInterface;

public class Server implements ItemListener {

	private ClientMainFrame clientMainFrame;

	public Server(ClientMainFrame clientMainFrame) {
		this.clientMainFrame = clientMainFrame;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			LocateRegistry.createRegistry(1026);
			System.out.println("Server đang chạy");
			while (true) {

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String chose = "";
		MainController mainController = new MainController();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			switch (e.getItem().toString()) {
			case "Tác giả":
				chose = "Author";
				break;

			case "Sinh viên":
				chose = "Student";
				break;

			case "Sách":
				chose = "Book";
				break;

			case "Chi tiết mượn":
				chose = "Borrow";
				break;

			}
			createConnect();
			this.clientMainFrame.tableChosen = chose;
			// Đi đến tạo bảng
			mainController.controllerPeform(this.clientMainFrame, chose);
			this.clientMainFrame.start = false;
		}
	}

	public void createConnect() {
		try {
			MainInterface mainInterface = new MainImp();
			Naming.rebind("rmi://localhost:1026/test", mainInterface);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

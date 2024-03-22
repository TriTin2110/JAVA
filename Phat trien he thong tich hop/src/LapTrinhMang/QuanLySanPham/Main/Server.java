package LapTrinhMang.QuanLySanPham.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import LapTrinhMang.QuanLySanPham.Controller.MainController;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainController mainController = new MainController();
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			System.out.println("Server đang chạy");
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				// Đọc yêu cầu từ người dùng
				String[] command = br.readLine().split(";");
				mainController.chose(command);
				// Thực hiện yêu cầu
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

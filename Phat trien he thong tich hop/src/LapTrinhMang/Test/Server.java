package LapTrinhMang.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Đã kết nối thành công");
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String userInput = br.readLine();
				// userInput = Thêm khách hàng;1;tin
				pw.println(luaChonCuaUser(userInput) + "");
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static int luaChonCuaUser(String userInput) {
		String[] income = userInput.split(";");
		// income[0] = Thêm khách hàng
		// income[1] = 1
		// income[2] = tin
		switch (income[0]) {
		case "Thêm khách hàng":
			try {
				KhachHangOperate khachHangOperate = new KhachHangOperate();
				return khachHangOperate.themKhachHang(new ModelKhachHang(Integer.parseInt(income[1]), income[2]));
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		}
		return 0;
	}
}

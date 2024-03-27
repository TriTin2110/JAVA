package LapTrinhMang.QuanLySanPham.Main;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 1026);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
//			String command = "Thêm;Product;P2;Kem;10000;C1";
//			String command = "Thêm;Company;C1;NCS;TPHCM";
//			String command = "Sửa;Company;C2;NTT;TPHCM";
//			String command = "Xóa;Product;P2";
//			String command = "Xóa;Company;C1";
			String command = "InDS;Company";
			pw.println(command);
			pw.flush();
			pw.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

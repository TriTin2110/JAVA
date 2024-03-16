package JDBC.BaiTapQuanLySanPham;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerProduct {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				// Gọi Class Controller để sử lý lựa chọn của user
				String result = Controller.userChosen(br.readLine());
				// Trả về kết quả cho client
				pw.println(result);
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

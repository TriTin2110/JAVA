package LapTrinhMang.ChuyenDoiTienTe;

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
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				int n = Integer.parseInt(br.readLine());
				pw.println(convertUSDToVND(n));
				pw.flush();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static int convertUSDToVND(int n) {
		return n * 24000;
	}
}

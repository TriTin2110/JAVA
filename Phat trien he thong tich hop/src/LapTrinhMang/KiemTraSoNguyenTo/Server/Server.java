package LapTrinhMang.KiemTraSoNguyenTo.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import LapTrinhMang.KiemTraSoNguyenTo.MyClass.MyClass;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			System.out.println("Server đang chạy");
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String[] input = br.readLine().split(" ");
				pw.println(MyClass.primeNumber(input));
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

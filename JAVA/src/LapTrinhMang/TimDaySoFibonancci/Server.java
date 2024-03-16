package LapTrinhMang.TimDaySoFibonancci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1025);

			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				int n = Integer.parseInt(bf.readLine());
				System.out.println(n);

				n = finbonancci(n);
				pw.println(n);
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static int finbonancci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else {
			return finbonancci(n - 1) + finbonancci(n - 2);
		}
	}
}

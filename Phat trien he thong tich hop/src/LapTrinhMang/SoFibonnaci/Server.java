package LapTrinhMang.SoFibonnaci;

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

				pw.println(convertFibonacci(Integer.parseInt(br.readLine())));
				pw.flush();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static int convertFibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else {
			return convertFibonacci(n - 1) + convertFibonacci(n - 2);
		}

	}
}

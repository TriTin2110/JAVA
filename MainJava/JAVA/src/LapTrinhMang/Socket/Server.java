package LapTrinhMang.Socket;

import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(100);
			while (true) {
				Socket socket = serverSocket.accept();
				MyProcess myProcess = new MyProcess(socket);
				myProcess.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

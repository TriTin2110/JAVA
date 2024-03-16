package LapTrinhMang.ChatClientServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(99);
			while (true) {
				Socket socket = serverSocket.accept();
				MyProcess myProcess = new MyProcess(socket);
				myProcess.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

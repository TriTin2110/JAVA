package LapTrinhMang.ChatClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyProcess extends Thread {
	private Socket socket;

	public MyProcess(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter pw = new PrintWriter(this.socket.getOutputStream());
			String message;
			while (true) {
				message = br.readLine();
				System.out.println("Client: " + message);

				System.out.print("Server: ");
				message = sc.nextLine();
				pw.println(message);
				pw.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

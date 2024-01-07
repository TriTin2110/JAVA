package LapTrinhMang.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class MyProcess extends Thread {
	private Socket socket;

	public MyProcess(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// Đọc dữ liệu từ màn hình console
			BufferedReader bfBufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			String messString;
			while (true) {
				// Server sẽ nhận được tin nhắn của client trước
				messString = bfBufferedReader.readLine();
				System.out.println("Client: " + messString);

				// Sau đó trả lời
				System.out.print("Server: ");
				messString = scanner.nextLine();
				pWriter.println(messString);
				pWriter.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

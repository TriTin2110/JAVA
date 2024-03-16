package LapTrinhMang.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 100);
			BufferedReader bfBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			String messString;
			while (true) {
				try {
					// Client sẽ nhập tin nhắn trước
					System.out.print("Client: ");
					messString = scanner.nextLine();
					pWriter.println(messString);
					pWriter.flush();

					// Sau đó client sẽ nhận tin nhắn từ server
					messString = bfBufferedReader.readLine();
					System.out.print("Server: " + messString + "\n");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Không thể kết nối!");
		}

	}

}

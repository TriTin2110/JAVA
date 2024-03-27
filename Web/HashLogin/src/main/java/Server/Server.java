package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Implement.MainImplement;
import Interface.MainInterface;
import Model.ModelAccount;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			System.out.println("Server đang chạy");
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String[] command = br.readLine().split(";");
				pw.println(proccessChose(command));
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static boolean proccessChose(String[] command) {
		MainInterface mainInterface = new MainImplement();
		switch (command[0]) {
		case "Thêm":
			return mainInterface.addAccount(new ModelAccount(command[1], command[2]));

		case "Tìm":
			return mainInterface.searchingAccount(new ModelAccount(command[1], command[2]));
		}
		return false;
	}
}

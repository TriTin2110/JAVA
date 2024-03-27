package Servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectToServer {

	public static boolean getConnectToServer(String method, String user, String password) {
		try {
			Socket socket = new Socket("localhost", 1026);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String command = method + ";" + user + ";" + password;
			pw.println(command);
			pw.flush();
			return Boolean.parseBoolean(br.readLine());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}

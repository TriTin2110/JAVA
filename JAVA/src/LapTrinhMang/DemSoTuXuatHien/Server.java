package LapTrinhMang.DemSoTuXuatHien;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String[] str = br.readLine().split(" ");
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				for (int i = 0; i < str.length; i++) {
					if (map.containsKey(str[i]))
						map.put(str[i], map.get(str[i]) + 1);
					else {
						map.put(str[i], 1);
					}
				}

				String result = "";
				for (int i = 0; i < str.length; i++) {
					if (!result.contains(str[i]))
						result += "Từ " + str[i] + " có " + map.get(str[i]) + " lần xuất hiện trong mảng" + "\n";
				}
				pw.println(result);
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

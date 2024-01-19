package LapTrinhMang.DemSoTu;

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
				String[] strSplit = br.readLine().split(" ");
				pw.println(strSplit.length);
				pw.flush();

				// Gửi trả kết quả cho client
				pw.println(count(strSplit));
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String count(String[] arr) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else {
				map.put(arr[i], 1);
			}
		}
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			// Nếu chuỗi result đã có chứa từ arr[i] thì sẽ bỏ qua ngược lại thì sẽ thêm vào
			// thông báo
			if (result.indexOf(arr[i]) < 0)
				result += arr[i] + " xuất hiện " + map.get(arr[i]) + " lần;";

		}

		// Trả về chuỗi kết quả và hiển thi
		return result;

	}
}

package LapTrinhMang.DemSoTuXuatHien;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Nguyen tri tri tin tin nguyen";
		try {
			Socket socket = new Socket("localhost", 1026);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();

			System.out.println("Kết quả: ");
			String result = "";
			while ((result = br.readLine()) != null) {
				System.out.println(result);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

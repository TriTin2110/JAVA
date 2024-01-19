package LapTrinhMang.ChuyenTien;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập n: ");
		int n = sc.nextInt();
		Locale lo = new Locale("vi", "vn");
		NumberFormat nf = NumberFormat.getInstance(lo);
		try {
			Socket socket = new Socket("localhost", 1026);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(n);
			pw.flush();

			System.out.println(n + " usd = " + nf.format(Integer.parseInt(br.readLine())) + "đ");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

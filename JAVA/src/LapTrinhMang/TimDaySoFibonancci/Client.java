package LapTrinhMang.TimDaySoFibonancci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập n: ");
		int n = sc.nextInt();

		try {
			Socket socket = new Socket("localhost", 1025);
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(n);
			pw.flush();

			System.out.println("Số Fibonacci ở vị trí " + n + " là: " + (Integer.parseInt(bf.readLine())));

			socket.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		sc.close();
	}
}

package LapTrinhMang.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Hãy nhập lựa chọn chọn của bạn:");
			System.out.println("1. Thêm khách hàng");
			System.out.println("2. Xóa khách hàng");
			System.out.println("0. Thoát");
			System.out.print("=> ");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				int id;
				String name;
				System.out.println("Hãy nhập id của khách hàng: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Hãy nhập tên của khách hàng: ");
				name = sc.nextLine();
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				// Thêm khách hàng;1;tin
				pw.println("Thêm khách hàng;" + id + ";" + name);
				pw.flush();
				System.out.println("Đã cập nhật thành công " + br.readLine());
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package LapTrinhMang.SapXepMangSoNguyen;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		System.out.println("Hãy nhập n: ");
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Hãy nhập số nguyên thứ " + (i + 1) + ": ");
			arr[i] = sc.nextInt();
		}
		try {
			Socket socket = new Socket("localhost", 1025);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			oos.writeObject((int[]) arr);
			oos.flush();

			arr = (int[]) ois.readObject();

			System.out.println("Dãy số sau khi được sắp xếp là:");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		sc.close();
	}
}

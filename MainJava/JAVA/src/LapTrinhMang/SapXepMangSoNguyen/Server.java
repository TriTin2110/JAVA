package LapTrinhMang.SapXepMangSoNguyen;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1025);
			while (true) {
				Socket socket = serverSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				int[] arr = (int[]) ois.readObject();
				for (int i = 0; i < arr.length - 1; i++) {
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[i] > arr[j]) {
							arr[j] = sort(arr[i], arr[i] = arr[j]);
						}
					}
				}
				oos.writeObject(arr);
				oos.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int sort(int a, int b) {
		return a;
	}
}

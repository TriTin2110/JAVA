package LapTrinhMang.SapXepMangSo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);

			while (true) {
				Socket socket = serverSocket.accept();
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				oos.writeObject(sort((int[]) ois.readObject()));
				oos.flush();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j])
					arr[j] = convert(arr[i], arr[i] = arr[j]);
			}
		}

		return arr;
	}

	public static int convert(int a, int b) {
		return a;
	}
}

package LapTrinhMang.KiemTraSoNguyenTo.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = Integer.parseInt(JOptionPane.showInputDialog("Hãy nhập số lượng phần tử"));
//		i = Math.round(i);
		String input = "";
		Random random = new Random();
		for (int j = 1; j <= 50; j++) {
			input += random.nextInt(0, 100);
			input += " ";
			if (j % 50 == 0) {
				input += "\n";
			}

		}
		JOptionPane.showMessageDialog(null, "Các số có trong mảng là:\n" + input);
		try {
			Socket socket = new Socket("localhost", 1026);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(input);
			pw.flush();
			String output = br.readLine();
			String result = "";
			if (output.equals("0")) {
				result = "Không có số nguyên tố nào được tìm thấy";
			} else {
				result = "Các số ban đầu là:\n" + input + "\nSố nguyên tố đầu tiên trong mảng nhập vào là: \n" + output;

			}
			JOptionPane.showMessageDialog(null, result);
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

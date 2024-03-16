package LapTrinhMang.ChuongTrinhQuanLySinhVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import MyClass.NumberController;

class Controller implements ActionListener {
	Client client;

	public Controller(Client client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Thêm sinh viên":
			try {
				boolean check = false;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String id = JOptionPane.showInputDialog(this.client, "Hãy nhập mã sinh viên");
				String name = JOptionPane.showInputDialog(this.client, "Hãy nhập tên sinh viên");
				int age = NumberController
						.checkCharacterIntNumber(JOptionPane.showInputDialog(this.client, "Hãy nhập tuổi sinh viên"));
				float gpa = NumberController
						.checkCharacterFloatNumber(JOptionPane.showInputDialog(this.client, "Hãy nhập GPA sinh viên"));
				pw.println("Thêm sinh viên;" + id + ";" + name + ";" + age + ";" + gpa);
				pw.flush();

				JOptionPane.showMessageDialog(this.client, "Đã thêm " + br.readLine() + " dòng!");
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

			break;

		case "Xóa sinh viên":
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String id = JOptionPane.showInputDialog(this.client, "Hãy nhập id của sinh viên");
				pw.println("Xóa sinh viên;" + id);
				pw.flush();

				JOptionPane.showMessageDialog(this.client, "Đã xóa " + br.readLine() + " dòng!");
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			break;

		case "Chỉnh sửa sinh viên":
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String id = JOptionPane.showInputDialog(this.client, "Hãy nhập id của sinh viên");
				String name = JOptionPane.showInputDialog(this.client, "Hãy nhập tên sinh viên");
				int age = NumberController
						.checkCharacterIntNumber(JOptionPane.showInputDialog(this.client, "Hãy nhập tuổi sinh viên"));
				float gpa = NumberController
						.checkCharacterFloatNumber(JOptionPane.showInputDialog(this.client, "Hãy nhập GPA sinh viên"));
				pw.println("Chỉnh sửa sinh viên;" + id + ";" + name + ";" + age + ";" + gpa);
				pw.flush();

				JOptionPane.showMessageDialog(this.client, "Đã chỉnh sửa " + br.readLine() + " dòng!");
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			break;

		case "Tìm sinh viên":
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String id = JOptionPane.showInputDialog(this.client, "Hãy nhập id của sinh viên");
				pw.println("Tìm sinh viên;" + id);
				pw.flush();

				String[] result = br.readLine().split(";");
				if (result[0].equals("null")) {
					JOptionPane.showMessageDialog(this.client, "Không tồn tại sinh viên có mã là: " + id);
				} else {
					JOptionPane.showMessageDialog(this.client, "Mã của sinh viên là: " + result[0]);
					JOptionPane.showMessageDialog(this.client, "Tên của sinh viên là: " + result[1]);
					JOptionPane.showMessageDialog(this.client, "Tuổi của sinh viên là: " + result[2]);
					JOptionPane.showMessageDialog(this.client, "GPA của sinh viên là: " + result[3]);
				}

				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			break;

		}
	}

}

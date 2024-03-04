package LapTrinhMang.ChuongTrinhQuanLySinhVien;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			System.out.println("Server đang chạy!");
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String[] str = br.readLine().split(";");
				if (str[0].equals("Tìm sinh viên")) {
					String result = "";
					ModelStudent modelStudent = new ProccessManageStudent().findingStudent(new ModelStudent(str[1]));
					if (modelStudent != null) {
						result = modelStudent.getId() + ";" + modelStudent.getName() + ";" + modelStudent.getAge() + ";"
								+ modelStudent.getGpa();
					} else {
						result = "null;";
					}

					pw.println(result);
					pw.flush();
				} else {
					pw.println(optionChoose(str));
					pw.flush();
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static int optionChoose(String[] str) {
		ManageStudent manageStudent = new ProccessManageStudent();
		switch (str[0]) {
		case "Thêm sinh viên":
			return manageStudent
					.addStudent(new ModelStudent(str[1], str[2], Integer.parseInt(str[3]), Float.parseFloat(str[4])));
		case "Xóa sinh viên":
			return manageStudent.removeStudent(new ModelStudent(str[1]));
		case "Chỉnh sửa sinh viên":
			return manageStudent
					.alterStudent(new ModelStudent(str[1], str[2], Integer.parseInt(str[3]), Float.parseFloat(str[4])));
		}
		return 0;
	}
}

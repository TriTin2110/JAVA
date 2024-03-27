package TaoFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

class DocvaGhiFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Ghi file (nhập chuỗi, mã hóa)
		// 2. Đọc file (lấy dữ liệu từ file, giải mã)
		// 3. Thoát
		File file = new File("D:\\File\\baiLam.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int choose = 0;
		boolean check = true;
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Ghi file");
						System.out.println("2. Đọc file");
						System.out.println("3. Thoát");
						System.out.print("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose < 1);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			switch (choose) {
			case 1:
				ghiFile(file);
				break;

			case 2:
				docFile(file);
				break;
			}
		} while (choose != 3);

		sc.close();
	}

	static void ghiFile(File file) {
		System.out.println("Hãy nhập nội dung mà bạn muốn ghi vào file: ");
		String noiDung = sc.nextLine();
		String maHoa = Base64.getEncoder().encodeToString(noiDung.getBytes());
		try {
			PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8);
			pw.print(maHoa);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void docFile(File file) {
		Scanner docFile = null;
		String ketQua = null;
		try {
			docFile = new Scanner(file);
			while (docFile.hasNextLine()) {
				ketQua = docFile.nextLine();
			}
//			List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
//			for (String string : list) {
//				ketQua = string;
//			}
			byte[] giaiMa = Base64.getDecoder().decode(ketQua.getBytes());
			String ketQuaSauGiaiMa = new String(giaiMa);
			System.out.println(String.valueOf(ketQuaSauGiaiMa));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

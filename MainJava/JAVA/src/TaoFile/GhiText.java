package TaoFile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class GhiText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File f = new File("D:\\File");
//		f.mkdir();
		Scanner sc = new Scanner(System.in);
		int maSo = 1;
		String hoTen;
		int ngay = 01, thang = 01, nam = 2000;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập mã số của sinh viên: ");
					maSo = sc.nextInt();
					check = true;
				} while (maSo < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Mã số của sinh viên không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		System.out.println("Hãy nhập họ tên của sinh viên: ");
		hoTen = sc.nextLine();

		// Nhập ngày sinh
		do {
			try {
				do {
					System.out.println("Hãy nhập ngày sinh của sinh viên: ");
					ngay = sc.nextInt();
					check = true;
				} while (ngay < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Ngày sinh của sinh viên không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		do {
			try {
				do {
					System.out.println("Hãy nhập tháng sinh của sinh viên: ");
					thang = sc.nextInt();
					check = true;
				} while (thang < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Tháng sinh của sinh viên không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		do {
			try {
				do {
					System.out.println("Hãy nhập năm sinh của sinh viên: ");
					nam = sc.nextInt();
					check = true;
				} while (nam < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Năm sinh của sinh viên không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		try {
			PrintWriter pw = new PrintWriter("D:\\File\\test.txt", "UTF-8");
			ngaySinh ngaySinh = new ngaySinh(ngay, thang, nam);
			hocSinh hs = new hocSinh(maSo, hoTen, ngaySinh);
			// Mã hóa thông tin
			// String thongTinMaHoa =
			// Base64.getEncoder().encodeToString(hs.toString().getBytes());
			pw.println(hs.toString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

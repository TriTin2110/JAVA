package HoaDonCaPhe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class HoaDonCaPhe {
	ArrayList<CaPhe> hoaDon;

	public HoaDonCaPhe() {
		this.hoaDon = new ArrayList<CaPhe>();
	}

	public void themHoaDon() {
		Scanner sc = new Scanner(System.in);
		String tenCaPhe;
		long giaCaPhe = 0;
		double khoiLuong = 0;
		boolean check = true;
		System.out.println("Hãy nhập tên của loại cà phê: ");
		tenCaPhe = sc.nextLine();
		do {
			try {
				do {
					System.out.println("Hãy nhập giá tiền của loại cà phê: ");
					giaCaPhe = sc.nextLong();
					check = true;
				} while (giaCaPhe < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá tiền không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		do {
			try {
				do {
					System.out.println("Hãy nhập khối lượng mua của loại cà phê: ");
					khoiLuong = sc.nextDouble();
					check = true;
				} while (khoiLuong < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Khối lượng mua không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		CaPhe caPhe = new CaPhe(tenCaPhe, giaCaPhe, khoiLuong);
		hoaDon.add(caPhe);
	}

	public void inHoaDon() {
		for (CaPhe caPhe : hoaDon) {
			System.out.println(caPhe);
		}
	}

	public void luuHoaDon(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (CaPhe caPhe : hoaDon) {
				oos.writeObject(caPhe);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void docHoaDon(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			CaPhe caPhe = null;
			while (true) {
				Object oj = ois.readObject();
				caPhe = (CaPhe) oj;
				if (caPhe == null) {
					break;
				} else {
					hoaDon.add(caPhe);
				}
			}
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Đã đọc file thành công");
		}
	}
}

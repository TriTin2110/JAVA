package LoaiPhuongTien;

import java.sql.Date;
import java.text.SimpleDateFormat;

class MainPhuongTien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		// Trường hợp 1
		Date d1 = new Date(2018 - 1900, 8 - 1, 30); // Date: 30/8/2018
		String date1 = df.format(d1);
		NgaySanXuat ngay1 = new NgaySanXuat(date1);
		HangSanXuat hsx1 = new HangSanXuat("Martin", "Việt Nam");
		XeDap xeDap = new XeDap(ngay1, hsx1, "Không");
		xeDap.tinhVanToc(20);
		xeDap.inThongTin();

		System.out.println("\n-------------------------------------------\n");

		// Trường hợp 2
		Date d2 = new Date(2022 - 1900, 5 - 1, 31); // 31/05/2022
		String date2 = df.format(d2);
		NgaySanXuat ngay2 = new NgaySanXuat(date2);
		HangSanXuat hsx2 = new HangSanXuat("Honda", "Nhật Bản");
		XeMay xeMay = new XeMay(ngay2, hsx2, "Xăng");
		xeMay.tinhVanToc(50);
		xeMay.inThongTin();
	}

}

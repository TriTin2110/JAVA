package Phim;

import java.text.NumberFormat;
import java.util.Locale;

class MainPhim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale l = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(l);

		NgayChieu ngay1 = new NgayChieu(21, 10, 2022);
		NgayChieu ngay2 = new NgayChieu(24, 12, 2023);

		HangPhim hang1 = new HangPhim("Vieon", "Việt Nam");
		HangPhim hang2 = new HangPhim("Netflix", "Hoa Kỳ");

		Phim phim1 = new Phim(ngay1, hang1, "Bố già", 500000, 2019);
		Phim phim2 = new Phim(ngay2, hang2, "Avartar", 1200000, 2020);

		System.out.println("\n-------------------- Phim 1 --------------------");
		System.out.println(phim1.inThongTin());
		System.out.println(phim1.tinhTien(3));
		System.out.println(phim1.tinhTongTien(10));
		System.out.println("\n-------------------- Phim 2 --------------------");
		System.out.println(phim2.inThongTin());
		System.out.println(phim2.tinhTien(5));
		System.out.println(phim2.tinhTongTien(20));
	}

}

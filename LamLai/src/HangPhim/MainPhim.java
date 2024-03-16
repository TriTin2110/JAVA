package HangPhim;

import java.sql.Date;
import java.text.SimpleDateFormat;

class MainPhim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		// Trường hợp 1
		Date d1 = new Date(System.currentTimeMillis());
		String date1 = df.format(d1);
		NgayChieu ngay1 = new NgayChieu(date1);

		HangPhim hangPhim = new HangPhim("Vieon", "Việt Nam");

		Phim phim1 = new Phim(ngay1, hangPhim, "Bố già", 300000, 3);
		phim1.inThongTinVe();

		System.out.println("\n------------------------\n");
		// Trường hợp 2
		@SuppressWarnings("deprecation")
		java.util.Date d2 = new java.util.Date(2025 - 1900, 12 - 1, 24, 15, 30);
		String date2 = df.format(d2);
		NgayChieu ngay2 = new NgayChieu(date2);

		HangPhim hangPhim2 = new HangPhim("Netflix", "Hoa Kỳ");

		Phim phim2 = new Phim(ngay2, hangPhim2, "Avatar", 550000, 6);
		phim2.inThongTinVe();
	}

}

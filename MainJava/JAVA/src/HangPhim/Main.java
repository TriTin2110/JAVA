package HangPhim;

class Main {
	public static void main(String[] args) {
		NgayChieu ngay1 = new NgayChieu(12, 8, 2023);
		NgayChieu ngay2 = new NgayChieu(21, 12, 2024);

		HangSanXuat hsx1 = new HangSanXuat("VietOn", "Việt Nam");
		HangSanXuat hsx2 = new HangSanXuat("NetFlix", "Hoa Kỳ");

		HangPhim phim1 = new HangPhim(ngay1, hsx1, "Bố già", 100000, 2023, 3);
		HangPhim phim2 = new HangPhim(ngay2, hsx2, "Avatar", 320000, 2022, 2);

		System.out.println("Thông tin của phim 1 là: ");
		System.out.println(phim1.inThongTin());
		System.out.println(phim1.kiemTraCungNamSanXuat(phim2));
		System.out.println(phim1.tinhTongTien());
		System.out.println(phim1.tinhTongTienSauKhiGiam(10));
		System.out.println("\n------------------------\n");
		System.out.println("Thông tin của phim 2 là: ");
		System.out.println(phim2.inThongTin());
		System.out.println(phim2.kiemTraCungNamSanXuat(phim2));
		System.out.println(phim2.tinhTongTien());
		System.out.println(phim2.tinhTongTienSauKhiGiam(20));
	}
}

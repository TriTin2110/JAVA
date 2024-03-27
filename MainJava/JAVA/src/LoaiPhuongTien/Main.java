package LoaiPhuongTien;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NgaySanXuat ngay1 = new NgaySanXuat(31, 04, 2003);
		NgaySanXuat ngay2 = new NgaySanXuat(31, 1, 2012);
		NgaySanXuat ngay3 = new NgaySanXuat(29, 02, 2020);

		HangSanXuat hsx1 = new HangSanXuat("VietnamAirlines", "Việt Nam");
		HangSanXuat hsx2 = new HangSanXuat("Honda", "Nhật Bản");
		HangSanXuat hsx3 = new HangSanXuat("Martin", "Việt Nam");

		MayBay mb = new MayBay(ngay1, hsx1, "Boeing 134");
		XeMay xm = new XeMay(ngay2, hsx2, "SH");
		XeDap xd = new XeDap(ngay3, hsx3, "Martin X10");

		System.out.println(mb.inThongTin());
		System.out.println(xm.inThongTin());
		System.out.println(xd.inThongTin());

		System.out.println(mb.tinhVanToc(500));
		System.out.println(xm.tinhVanToc(50));
		System.out.println(xd.tinhVanToc(10));
	}

}

public class Test {
        public static void main(String[] args) {
                // Ngay ngay1 = new Ngay(21, 10, 2003);
                // Ngay ngay2 = new Ngay(24, 12, 2006);

                // TacGia tacGia1 = new TacGia(ngay1, "Nguyễn Trí Tín");
                // TacGia tacGia2 = new TacGia(ngay2, "Nguyễn Ngọc Minh");

                // Sach sach1 = new Sach("Lập Trình Java", 100000, 2023, tacGia1, ngay1);
                // Sach sach2 = new Sach("Luật", 50000, 2023, tacGia1, ngay2);

                // System.out.println(sach1.kiemTraSachCoCungNamXuatBang(sach2));
                // System.out.println(sach1.inThongTinSach());
                // System.out.println(sach1.tinhTongTienSachSauKhiGiam(10));

                // Ngay ngay1 = new Ngay(21, 10, 2023);
                // Ngay ngay2 = new Ngay(21, 10, 2023);

                // HangPhim hang1 = new HangPhim("VieOn", "Việt Nam");
                // HangPhim hang2 = new HangPhim("NetFlix", "Hoa Kỳ");

                // Phim phim1 = new Phim(hang1, ngay1, "Bố già", 100000, 2023);
                // Phim phim2 = new Phim(hang2, ngay2, "Avartar", 500000, 2021);
                
                // System.out.println(phim1.KiemTraPhimCoTrungNgayChieu(phim2));
                // System.out.println(phim2.tinhGiaVeSauKhiGiam(10));

                // System.out.println(phim1.inThongTinPhim());
                // System.out.println("\n-------------------\n");
                // System.out.println(phim2.inThongTinPhim());

                // Ngay ngay1 = new Ngay(21, 10, 2003);
                // Ngay ngay2 = new Ngay(24, 12, 2006);

                // Lop lop1 = new Lop("Kỹ thuật lập trình", "CNTT");
                // Lop lop2 = new Lop("Luật kinh tế", "Luật");

                // SinhVien sv1 = new SinhVien(lop1, ngay1, "Nguyễn Trí Tín", 21121971, 8.5);
                // SinhVien sv2 = new SinhVien(lop1, ngay1, "Nguyễn Ngọc Minh", 21121971, 9.5);

                // System.out.println(sv1.inThongTinSinhVien());
                // System.out.println(sv1.kiemTraSinhVienCoQuaMon(5));
                // System.out.println(sv1.kiemTraSinhVienCoTrungMaSoSinhVien(sv2));

                Ngay ngay1 = new Ngay(21, 10, 2003);
                Ngay ngay2 = new Ngay(24, 12, 2008);

                HangSX hang1 = new HangSX("Dell", "Hoa Kỳ");
                HangSX hang2 = new HangSX("Asus", "Đài Loan");

                MayTinh may1 = new MayTinh(hang1, ngay1, 35.5, 2023);
                MayTinh may2 = new MayTinh(hang2, ngay2, 25.3, 2025);

                System.out.println(may1.kiemTraMayTinhCoReHonMayKhac(may2));
                System.out.println(may1.kiemTraThongTinCuaMay());
                System.out.println("\n--------------------------------\n");
                System.out.println(may2.kiemTraThongTinCuaMay());
        }
}

public class TestHoaDonCaPhe {
        public static void main(String[] args) {
                double giamGia = 100000;
                double tonKho = 5;
                int phanTram = 10;
                HoaDon hd1 = new HoaDon("Trung nguyên", 100000, 11);
                HoaDon hd2 = new HoaDon("Phố", 50000, 5);

                System.out.println(hd1.tinhTongTien());
                System.out.println(hd1.kiemTraLuongTonKho(5));
                System.out.println(hd1.kiemTraHoaDonCoDuocGiamGia(giamGia));
                System.out.println(hd1.tinhSoTienDuocGiamGia(10));
                System.out.println(hd1.tinhTongTienSauKhiDuocGiamGia());
        }
}

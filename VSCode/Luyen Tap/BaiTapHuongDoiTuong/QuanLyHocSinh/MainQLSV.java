package QuanLyHocSinh;

public class MainQLSV {
        public static void main(String[] args) {
                Lop lop1 = new Lop("123");
                Lop lop2 = new Lop("122");
                HocSinh hocSinh1 = new HocSinh("Nguyễn Trí Tín 1", "DN", 24, lop1);
                HocSinh hocSinh2 = new HocSinh("Nguyễn Trí Tín 2", "TPHCM", 19, lop2);
                HocSinh hocSinh3 = new HocSinh("Nguyễn Trí Tín 3", "TPHCM", 19, lop1);
                QLHS qlhs = new QLHS();
                qlhs.themHocSinh(hocSinh3);
                qlhs.themHocSinh(hocSinh1);
                qlhs.themHocSinh(hocSinh2);
                qlhs.hienThiDanhSachHocSinh();
                // qlhs.hienThiHocSinhTrenHaiMuoi();
                // qlhs.hienThiHocSinhTheoDieuKien();
        }
}

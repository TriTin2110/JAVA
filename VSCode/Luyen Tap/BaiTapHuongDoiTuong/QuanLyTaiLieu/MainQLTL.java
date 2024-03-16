package QuanLyTaiLieu;

import java.util.Calendar;

public class MainQLTL {
        public static void main(String[] args) {
                Sach sach = new Sach(3, 10, "Kim Đồng", "NTT", 30);
                TapChi tapChi = new TapChi(2, 10, "NTT", 30, 10);
                Bao bao = new Bao(1, 10, "NTT", Calendar.getInstance().getTime());
                QLTL qltl = new QLTL();
                qltl.themMoiTaiLieu(tapChi);
                qltl.themMoiTaiLieu(sach);
                qltl.themMoiTaiLieu(bao);
                qltl.hienThiDanhSachTaiLieu();
                qltl.timKiemTaiLieu(new TaiLieu(1));
        }
}

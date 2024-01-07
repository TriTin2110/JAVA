package QuanLyCanBo;

import java.util.Scanner;

public class MainQLCB {
        public static void main(String[] args) {
                CongNhan congNhan = new CongNhan("Nguyễn Trí Tín", "113", 20, true, 2);
                KySu kySu = new KySu("NTT", "456", 20, true, "CNTT");
                NhanVien nhanVien = new NhanVien("Nguyễn Ngọc Minh", "789", 20, false, "Luật");
                QLCB qlcb = new QLCB();
                qlcb.themCanBo(nhanVien);
                qlcb.themCanBo(kySu);
                qlcb.themCanBo(congNhan);
                qlcb.xuatDanhSachCanBo();
                qlcb.timKiemTheoTen("Ngọc Minh");
        }
}

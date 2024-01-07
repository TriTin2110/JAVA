package QuanLyTaiLieu;

import java.util.LinkedList;

public class QLTL {
        LinkedList<TaiLieu> tl;

        public QLTL() {
                this.tl = new LinkedList<>();
        }

        public LinkedList<TaiLieu> getTl() {
                return tl;
        }

        public void setTl(LinkedList<TaiLieu> tl) {
                this.tl = tl;
        }

        public void themMoiTaiLieu(TaiLieu taiLieuMoi) {
                if (kiemTraMaTaiLieu(taiLieuMoi) == -1)
                        this.tl.add(taiLieuMoi);
                else
                        System.out.println("Phát hiện trùng mã tài liệu!");
        }

        public void hienThiDanhSachTaiLieu() {
                this.tl.forEach(t -> System.out.println(t.toString()));
        }

        public void timKiemTaiLieu(TaiLieu taiLieu) {
                if (kiemTraMaTaiLieu(taiLieu) != -1) {
                        System.out.println(tl.get(kiemTraMaTaiLieu(taiLieu)));
                } else
                        System.out.println("Không tìm thấy tài liệu có mã là: " + taiLieu.getMaTaiLieu());
        }

        public int kiemTraMaTaiLieu(TaiLieu taiLieu) {

                for (TaiLieu taiLieu2 : tl) {
                        if (taiLieu2.getMaTaiLieu() == taiLieu.getMaTaiLieu())
                                return tl.indexOf(taiLieu2);
                }
                return -1;
        }
}

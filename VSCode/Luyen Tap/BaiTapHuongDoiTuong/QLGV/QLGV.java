package QLGV;

import java.util.LinkedList;

public class QLGV {
        LinkedList<Nguoi> danhSachGiaoVien;

        public QLGV() {
                danhSachGiaoVien = new LinkedList<>();
        }

        public LinkedList<Nguoi> getDanhSachGiaoVien() {
                return danhSachGiaoVien;
        }

        public void setDanhSachGiaoVien(LinkedList<Nguoi> danhSachGiaoVien) {
                this.danhSachGiaoVien = danhSachGiaoVien;
        }

        public void themGiaoVien(Nguoi nguoiMoi) {
                this.danhSachGiaoVien.add(nguoiMoi);
        }

        public void xoaGiaoVien(Nguoi nguoi) {
                if (timMaGiaoVien(nguoi) == null)
                        System.out.println("Giáo viên không tồn tại trong danh sách");
                else
                        this.danhSachGiaoVien.remove(timMaGiaoVien(nguoi));
        }

        public Nguoi timMaGiaoVien(Nguoi nguoi) {
                for (Nguoi ng : danhSachGiaoVien) {
                        if (ng.getMaGiaoVien() == nguoi.getMaGiaoVien())
                                return ng;
                }
                return null;
        }

        public void tinhLuongThucGiaoVien(Nguoi nguoi) {
                nguoi.luong.setLuongThucLinh(
                                nguoi.luong.getLuongCung() + nguoi.luong.getLuongThuong() - nguoi.luong.getPhat());
        }

        public void inDanhSach() {
                this.danhSachGiaoVien.forEach(ds -> {
                        tinhLuongThucGiaoVien(ds);
                        System.out.println(ds.toString());
                });
        }
}

package QuanLyHocVien;

import java.sql.Date;
import java.util.Comparator;
import java.util.LinkedList;

public class Classroom {
        private int maLop, maKhoaHoc, soLuongHocVienToiDa;
        private double chiPhiHocTap;
        Date ngayMoLop;
        LinkedList<HocVien> danhSachHocVien;

        public Classroom() {
        }

        public Classroom(int maLop, int maKhoaHoc, int soLuongHocVienToiDa, double chiPhiHocTap, Date ngayMoLop) {
                this.maLop = maLop;
                this.maKhoaHoc = maKhoaHoc;
                this.soLuongHocVienToiDa = soLuongHocVienToiDa;
                this.chiPhiHocTap = chiPhiHocTap;
                this.ngayMoLop = ngayMoLop;
                this.danhSachHocVien = new LinkedList<>();
        }

        public int getMaLop() {
                return maLop;
        }

        public void setMaLop(int maLop) {
                this.maLop = maLop;
        }

        public int getMaKhoaHoc() {
                return maKhoaHoc;
        }

        public void setMaKhoaHoc(int maKhoaHoc) {
                this.maKhoaHoc = maKhoaHoc;
        }

        public int getSoLuongHocVienToiDa() {
                return soLuongHocVienToiDa;
        }

        public void setSoLuongHocVienToiDa(int soLuongHocVienToiDa) {
                this.soLuongHocVienToiDa = soLuongHocVienToiDa;
        }

        public double getChiPhiHocTap() {
                return chiPhiHocTap;
        }

        public void setChiPhiHocTap(double chiPhiHocTap) {
                this.chiPhiHocTap = chiPhiHocTap;
        }

        public Date getNgayMoLop() {
                return ngayMoLop;
        }

        public void setNgayMoLop(Date ngayMoLop) {
                this.ngayMoLop = ngayMoLop;
        }

        // PT
        public void themHocVien(HocVien hocVien) {
                this.danhSachHocVien.add(hocVien);
        }

        public HocVien timKiemHocVienTheoTen(HocVien hocVien) {
                for (HocVien ds : danhSachHocVien) {
                        if (ds.getTen().equals(hocVien.getTen()))
                                return ds;
                }
                return null;
        }

        public void sapXepDanhSachLopTheoTen() {
                danhSachHocVien.sort(new Comparator<HocVien>() {
                        @Override
                        public int compare(HocVien o1, HocVien o2) {
                                // TODO Auto-generated method stub
                                if (o1.getTen().compareTo(o2.getTen()) > 0)
                                        return 1;
                                else if (o1.getTen().compareTo(o2.getTen()) < 0)
                                        return -1;
                                else
                                        return 0;
                        }

                });
        }

        public double tinhTongChiPhiLopHoc() {
                return this.soLuongHocVien() * this.getChiPhiHocTap();
        }

        public void inDanhSachHocVien() {
                this.danhSachHocVien.forEach(ds -> System.out.println(ds.toString()));
        }

        public int soLuongHocVien() {
                return this.danhSachHocVien.size();
        }
}

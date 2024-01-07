package QuanLyHocVien;

import java.sql.Date;

public class HocVien {
        private int maHocVien;
        private String tenHocVien, diaChi;
        private long soDienThoai;

        public HocVien(int maHocVien, String tenHocVien, String diaChi, long soDienThoai) {
                this.maHocVien = maHocVien;
                this.tenHocVien = tenHocVien;
                this.diaChi = diaChi;
                this.soDienThoai = soDienThoai;
        }

        public int getMaHocVien() {
                return maHocVien;
        }

        public void setMaHocVien(int maHocVien) {
                this.maHocVien = maHocVien;
        }

        public String getTenHocVien() {
                return tenHocVien;
        }

        public void setTenHocVien(String tenHocVien) {
                this.tenHocVien = tenHocVien;
        }

        public String getDiaChi() {
                return diaChi;
        }

        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }

        public long getSoDienThoai() {
                return soDienThoai;
        }

        public void setSoDienThoai(long soDienThoai) {
                this.soDienThoai = soDienThoai;
        }

        public String getTen() {
                String ten = this.getTenHocVien();
                return ten.substring(this.getTenHocVien().lastIndexOf(" ") + 1);
        }

        @Override
        public String toString() {
                return "HocVien [maHocVien=" + maHocVien + ", tenHocVien=" + tenHocVien + ", diaChi=" + diaChi
                                + ", soDienThoai=" + soDienThoai + "]";
        }

}

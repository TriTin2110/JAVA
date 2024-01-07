package QuanLyThiSinh;

import java.io.Serializable;

public class ThiSinh implements Serializable {
        private int soBaoDanh, mucUuTien;
        private String hoTen, diaChi;

        public ThiSinh(int soBaoDanh, int mucUuTien, String hoTen, String diaChi) {
                this.soBaoDanh = soBaoDanh;
                this.mucUuTien = mucUuTien;
                this.hoTen = hoTen;
                this.diaChi = diaChi;
        }

        public ThiSinh(int soBaoDanh) {
                this.soBaoDanh = soBaoDanh;
        }

        public int getSoBaoDanh() {
                return soBaoDanh;
        }

        public void setSoBaoDanh(int soBaoDanh) {
                this.soBaoDanh = soBaoDanh;
        }

        public int getMucUuTien() {
                return mucUuTien;
        }

        public void setMucUuTien(int mucUuTien) {
                this.mucUuTien = mucUuTien;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public String getDiaChi() {
                return diaChi;
        }

        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }

        @Override
        public String toString() {
                return "ThiSinh [soBaoDanh=" + soBaoDanh + ", mucUuTien=" + mucUuTien + ", hoTen=" + hoTen + ", diaChi="
                                + diaChi + "]";
        }

}

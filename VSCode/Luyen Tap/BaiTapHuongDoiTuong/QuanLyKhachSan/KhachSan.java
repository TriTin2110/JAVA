package QuanLyKhachSan;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class KhachSan implements Serializable {
        private int soNgayThue;
        private String loaiPhong;
        private double gia;
        private Nguoi nguoi;
        LocalDate ngayTraPhong, ngayDatPhong;
        int thoiGianConLai;

        public KhachSan(int soNgayThue, String loaiPhong, Nguoi nguoi) {
                this.soNgayThue = soNgayThue;
                this.loaiPhong = loaiPhong;
                this.nguoi = nguoi;
                this.ngayDatPhong = LocalDate.now();
        }

        public int getSoNgayThue() {
                return soNgayThue;
        }

        public void setSoNgayThue(int soNgayThue) {
                this.soNgayThue = soNgayThue;
        }

        public String getLoaiPhong() {
                return loaiPhong;
        }

        public void setLoaiPhong(String loaiPhong) {
                this.loaiPhong = loaiPhong;
        }

        public Nguoi getNguoi() {
                return nguoi;
        }

        public void setNguoi(Nguoi nguoi) {
                this.nguoi = nguoi;
        }

        public double getGia() {
                return gia;
        }

        public void setGiaA() {
                this.gia = 500 * this.getSoNgayThue();
        }

        public void setGiaB() {
                this.gia = 300 * this.getSoNgayThue();
        }

        public void setGiaC() {
                this.gia = 100 * this.getSoNgayThue();
        }

        public void setGia(double gia) {
                this.gia = gia;
        }

        public LocalDate getNgayDatPhong() {
                return ngayDatPhong;
        }

        public void setNgayDatPhong(LocalDate ngayDatPhong) {
                this.ngayDatPhong = ngayDatPhong;
        }

        public LocalDate getNgayTraPhong() {
                return ngayTraPhong;
        }

        public void setNgayTraPhong() {
                this.ngayTraPhong = ngayDatPhong.plusDays(soNgayThue);
        }

        public int getThoiGianConLai() {
                return thoiGianConLai;
        }

        // Đặt thời gian còn lại dựa theo ngày hiện tại trên hệ thống
        public void setThoiGianConLai() {
                Date ngayTra = Date.valueOf(ngayTraPhong);
                // Lấy ngày trả trừ ngày hiện tại
                this.thoiGianConLai = ngayTra.getDate() -
                                Date.valueOf(LocalDate.now()).getDate();
        }

        @Override
        public String toString() {
                return "KhachSan [soNgayThue=" + soNgayThue + ", loaiPhong=" + loaiPhong + ", gia=" + gia
                                + ", ngayTraPhong=" + ngayTraPhong + ", ngayDatPhong=" + ngayDatPhong
                                + ", thoiGianConLai=" + thoiGianConLai + "]" + "\nnguoi="
                                + nguoi;
        }

}

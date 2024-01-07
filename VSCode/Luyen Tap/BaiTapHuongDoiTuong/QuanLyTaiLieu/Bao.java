package QuanLyTaiLieu;

import java.sql.Date;

public class Bao extends TaiLieu {
        private java.util.Date ngayPhatHanh;

        public Bao(int maTaiLieu, int soPhatHanh, String nhaXuatBan, java.util.Date date) {
                super(maTaiLieu, soPhatHanh, nhaXuatBan);
                this.ngayPhatHanh = date;
        }

        public java.util.Date NgayPhatHanh() {
                return ngayPhatHanh;
        }

        public void setNgayPhatHanh(Date ngayPhatHanh) {
                this.ngayPhatHanh = ngayPhatHanh;
        }

        @Override
        public String toString() {
                return "Bao [ngayPhatHanh=" + ngayPhatHanh + ", maTaiLieu="
                                + super.getMaTaiLieu()
                                + ", soBanPhatHanh=" + super.getSoPhatHanh() + ", nhaXuatBan=" + super.getNhaXuatBan()
                                + "]";
        }

}

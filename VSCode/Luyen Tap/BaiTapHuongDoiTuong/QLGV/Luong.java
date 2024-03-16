package QLGV;

import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

class Luong {
        private double luongCung, luongThuong, phat, luongThucLinh;

        public Luong(double luongCung, double luongThuong, double phat) {
                this.luongCung = Math.round(luongCung);
                this.luongThuong = Math.round(luongThuong);
                this.phat = Math.round(phat);
        }

        public double getLuongCung() {
                return luongCung;
        }

        public void setLuongCung(double luongCung) {
                this.luongCung = luongCung;
        }

        public double getLuongThuong() {
                return luongThuong;
        }

        public void setLuongThuong(double luongThuong) {
                this.luongThuong = luongThuong;
        }

        public double getPhat() {
                return phat;
        }

        public void setPhat(double phat) {
                this.phat = phat;
        }

        public double getLuongThucLinh() {
                return luongThucLinh;
        }

        public void setLuongThucLinh(double luongThucLinh) {
                this.luongThucLinh = Math.round(luongThucLinh);
        }

        @Override
        public String toString() {
                Locale lo = new Locale("vi", "vn");
                return "Luong [luongCung=" + NumberFormat.getInstance().format(luongCung) + "đ, luongThuong="
                                + NumberFormat.getInstance().format(luongThuong) + "đ, phat="
                                + NumberFormat.getInstance().format(phat)
                                + "đ, luongThucLinh=" + NumberFormat.getInstance().format(luongThucLinh) + "đ]";
        }

}

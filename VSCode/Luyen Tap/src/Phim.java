public class Phim {
        private HangPhim hangPhim;
        private Ngay ngay;
        private String tenPhim;
        private double giaVe;
        private int namSX;

        public Phim(HangPhim hangPhim, Ngay ngay, String tenPhim, double giaVe, int namSX) {
                this.hangPhim = hangPhim;
                this.ngay = ngay;
                this.tenPhim = tenPhim;
                this.giaVe = giaVe;
                this.namSX = namSX;
        }

        /**
         * booleanKiemTraPhimCoTrungNgayChieu(Phim phimKhac)
         */
        public boolean KiemTraPhimCoTrungNgayChieu(Phim phimKhac) {
                return ngay.getDay()+ngay.getMonth()+ngay.getYear() == phimKhac.ngay.getDay()+phimKhac.ngay.getMonth()+phimKhac.ngay.getYear(); 
        }

        /**
         * tinhGiaVeSauKhiGiam(double phanTram)
         */
        public long tinhGiaVeSauKhiGiam(double phanTram) {
                return (long) Math.round((giaVe * ((100 - phanTram)/100)));
        }

        /**
         * inThongTinPhim
         */
        public String inThongTinPhim() {
                return tenPhim+"\n"+giaVe+"\n"+namSX+"\n"+hangPhim.getTenHangPhim()+"\n"+hangPhim.getQuocGia()+"\n"+ngay.toString();
        }
}

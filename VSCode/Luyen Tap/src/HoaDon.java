public class HoaDon {
        private String tenLoaiCaPhe;
        private double gia, khoiLuong, giamGia;
        private int phanTram;

        public HoaDon(String tenLoaiCaPhe, double gia, double khoiLuong) {
                this.tenLoaiCaPhe = tenLoaiCaPhe;
                this.gia = gia;
                this.khoiLuong = khoiLuong;
        }

        public String getTenLoaiCaPhe() {
                return tenLoaiCaPhe;
        }

        public void setTenLoaiCaPhe(String tenLoaiCaPhe) {
                this.tenLoaiCaPhe = tenLoaiCaPhe;
        }

        public double getGia() {
                return gia;
        }

        public void setGia(double gia) {
                this.gia = gia;
        }

        public double getKhoiLuong() {
                return khoiLuong;
        }

        public void setKhoiLuong(double khoiLuong) {
                this.khoiLuong = khoiLuong;
        }

        /**
         * tinhTongTien()
         */
        public long tinhTongTien() {
                return (long) Math.round(gia * khoiLuong);
        }

        /**
         * kiemTraLuongTonKho(double tonKho)
         */
        public boolean kiemTraLuongTonKho(double tonKho) {
                return khoiLuong < tonKho;
        }

        /**
         * kiemTraHoaDonCoDuocGiamGia
         */
        public boolean kiemTraHoaDonCoDuocGiamGia(double giamGia) {
                this.giamGia = giamGia;
                return tinhTongTien() > giamGia;
        }

        /**
         * tinhSoTienDuocGiamGia(int phanTram)
         */
        public long tinhSoTienDuocGiamGia(int phanTram) {
                this.phanTram = phanTram;
                return (kiemTraHoaDonCoDuocGiamGia(giamGia)) ? Math.round((tinhTongTien() * phanTram) / 100) : 0;
        }

        /**
         * tongTienSauKhiDuocGiamGia()
         */
        public long tinhTongTienSauKhiDuocGiamGia() {
                return (long) Math.round(tinhTongTien() - tinhSoTienDuocGiamGia(phanTram));
        }
}

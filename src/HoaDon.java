/**
 * HoaDon
 */
public class HoaDon {

        private String tenLoaiCaPhe;
        private double gia, khoiLuong, giamGia, phanTram;

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

        public long tinhTongTien() {
                return (long) Math.round(gia * khoiLuong);
        }

        /**
         * kiemTraLuongTonKho
         */
        public boolean kiemTraLuongTonKho(double luongTonKho) {
                return khoiLuong > luongTonKho;
        }

        /**
         * kiemTraHoaDonCoDuocGiamGia(double giamGia)
         */
        public boolean kiemTraHoaDonCoDuocGiamGia(double giamGia) {
                this.giamGia = giamGia;
                return tinhTongTien() > giamGia;
        }

        /**
         * tinhSoTienDuocGiam(double phanTram)
         */
        public double tinhSoTienDuocGiam(double phanTram) {
                this.phanTram = phanTram;
                return (kiemTraHoaDonCoDuocGiamGia(giamGia)
                                ? (long) Math.round(((tinhTongTien() * phanTram) / 100))
                                : (long) 0);
        }

        public long tinhTongTienSauKhiDuocGiam() {
                return (long) Math.round(tinhTongTien() - tinhSoTienDuocGiam(phanTram));
        }
}
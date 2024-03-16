package HoaDonCaPhe;

public class HoaDon {
        String tenLoaiCaPhe;
        double khoiLuongMua;
        long giaCaPhe;

        public HoaDon(String tenLoaiCaPhe, double khoiLuongMua, long giaCaPhe) {
                this.tenLoaiCaPhe = tenLoaiCaPhe;
                this.khoiLuongMua = khoiLuongMua;
                this.giaCaPhe = giaCaPhe;
        }

        public String getTenLoaiCaPhe() {
                return tenLoaiCaPhe;
        }

        public void setTenLoaiCaPhe(String tenLoaiCaPhe) {
                this.tenLoaiCaPhe = tenLoaiCaPhe;
        }

        public double getKhoiLuongMua() {
                return khoiLuongMua;
        }

        public void setKhoiLuongMua(double khoiLuongMua) {
                this.khoiLuongMua = khoiLuongMua;
        }

        public long getGiaCaPhe() {
                return giaCaPhe;
        }

        public void setGiaCaPhe(long giaCaPhe) {
                this.giaCaPhe = giaCaPhe;
        }

        @Override
        public String toString() {
                return "HoaDon [tenLoaiCaPhe=" + tenLoaiCaPhe + ", khoiLuongMua=" + khoiLuongMua + ", giaCaPhe="
                                + giaCaPhe + "]";
        }

        /**
         * tinhTongTienHoaDon
         */
        public long tinhTongTienHoaDon() {
                return (long) Math.round(this.getGiaCaPhe() * this.getKhoiLuongMua());
        }

        /**
         * kiemTraHoaDonCoDuocGiam()
         */
        public String kiemTraHoaDonCoDuocGiam(int soLuongMua) {
                return (this.khoiLuongMua >= soLuongMua) ? "Có" : "Không";
        }

        /**
         * tinhTongTienSauKhiGiamGia(boolean kiemTraGiamGia)
         */
        public long tinhTongTienSauKhiGiamGia(String kiemTraGiamGia) {
                return (kiemTraGiamGia.equals("Có"))
                                ? (long) Math.round(tinhTongTienHoaDon() * 0.9)
                                : tinhTongTienHoaDon();
        }
}

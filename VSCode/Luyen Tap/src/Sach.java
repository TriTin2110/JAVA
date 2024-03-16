public class Sach {
        private TacGia tacGia;
        private Ngay ngay;
        private String tenSach;
        private double gia;
        private int namXB;

        public Sach(String tenSach, double gia, int namXB, TacGia tacGia, Ngay ngay) {
                this.tenSach = tenSach;
                this.gia = gia;
                this.namXB = namXB;
                this.tacGia = tacGia;
                this.ngay = ngay;
        }

        public TacGia getTacGia() {
                return tacGia;
        }

        public void setTacGia(TacGia tacGia) {
                this.tacGia = tacGia;
        }

        public double getGia() {
                return gia;
        }

        public void setGia(double gia) {
                this.gia = gia;
        }

        public int getNamXB() {
                return namXB;
        }

        public void setNamXB(int namXB) {
                this.namXB = namXB;
        }

        /**
         * kiemTraSachCoCungNamXuatBang
         */
        public boolean kiemTraSachCoCungNamXuatBang(Sach sachKhac) {
                return namXB == sachKhac.namXB;
        }

        /**
         * inThongTinSach
         */
        public String inThongTinSach() {
                return this.tenSach + "\n" + this.gia + "\n" + this.namXB + "\n" + tacGia.getTacGia() + "\n"
                                + ngay.getDay() + "/" + ngay.getMonth() + "/" + ngay.getYear();
        }

        /**
         * tinhTongTienSachSauKhiGiam(long phanTram)
         */
        public long tinhTongTienSachSauKhiGiam(double phanTram) {
                return  Math.round(gia * ((100 - phanTram) / 100));

        }
}

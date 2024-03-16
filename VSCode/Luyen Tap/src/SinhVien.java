public class SinhVien {
        private Lop lop;
        private Ngay ngaySinh;
        private String tenSV;
        private int MSSV;
        private double diemGPA;

        public SinhVien(Lop lop, Ngay ngay, String ten, int mssv, double diemGPA) {
                this.lop = lop;
                this.ngaySinh = ngay;
                this.tenSV = ten;
                this.MSSV = mssv;
                this.diemGPA = diemGPA;
        }

        public String getTenSV() {
                return tenSV;
        }

        public void setTenSV(String tenSV) {
                this.tenSV = tenSV;
        }

        public int getMSSV() {
                return MSSV;
        }

        public void setMSSV(int mSSV) {
                MSSV = mSSV;
        }

        public double getDiemGPA() {
                return diemGPA;
        }

        public void setDiemGPA(double diemGPA) {
                this.diemGPA = diemGPA;
        }

        /**
         * inThongTinSinhVien()
         */
        public String inThongTinSinhVien() {
                return this.tenSV + "\n" + this.MSSV + "\n" + this.diemGPA + "\n" + this.lop.getTenKhoa() + "\n"
                                + this.lop.getTenLop() + "\n" + this.ngaySinh.toString();

        }

        /**
         * kiemTraSinhVienCoQuaMon(double diemTB)
         */
        public boolean kiemTraSinhVienCoQuaMon(double diemTB) {
                return this.diemGPA > diemTB;
        }

        /**
         * kiemTraSinhVienCoTrungMaSoSinhVien(SinhVien sinhVienKhac)
         */
        public boolean kiemTraSinhVienCoTrungMaSoSinhVien(SinhVien sinhVienKhac) {
                return MSSV == sinhVienKhac.MSSV;
        }
}

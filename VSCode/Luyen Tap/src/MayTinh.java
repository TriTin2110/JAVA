public class MayTinh {
        private HangSX hangSX;
        private Ngay ngaySX;
        private double giaTien;
        private int namSX;

        public MayTinh(HangSX hangSX, Ngay ngay, double gia, int namSX) {
                this.hangSX = hangSX;
                this.ngaySX = ngay;
                this.giaTien = gia;
                this.namSX = namSX;
        }

        public double getGiaTien() {
                return giaTien;
        }

        public void setGiaTien(double giaTien) {
                this.giaTien = giaTien;
        }

        public Ngay getNgaySX() {
                return ngaySX;
        }

        public void setNgaySX(Ngay ngaySX) {
                this.ngaySX = ngaySX;
        }

        /**
         * kiemTraMayTinhCoReHonMayKhac(MayTinh mayKhac)
         */
        public boolean kiemTraMayTinhCoReHonMayKhac(MayTinh mayKhac) {
                return giaTien < mayKhac.giaTien;
        }

        /**
         * kiemTraThongTinCuaMay()
         */
        public String kiemTraThongTinCuaMay() {
                return this.giaTien+"\n"+this.namSX+"\n"+hangSX.getQuocGia()+"\n"+hangSX.getTenHang()+"\n"+ngaySX.toString();
                
        }
}

package QuanLyThiSinh;

public class KhoiA extends ThiSinh {
        private int toan, ly, hoa;

        public KhoiA(int soBaoDanh, int mucUuTien, String hoTen, String diaChi, int toan, int ly, int hoa) {
                super(soBaoDanh, mucUuTien, hoTen, diaChi);
                this.toan = toan;
                this.ly = ly;
                this.hoa = hoa;
        }

        public int getToan() {
                return toan;
        }

        public void setToan(int toan) {
                this.toan = toan;
        }

        public int getLy() {
                return ly;
        }

        public void setLy(int ly) {
                this.ly = ly;
        }

        public int getHoa() {
                return hoa;
        }

        public void setHoa(int hoa) {
                this.hoa = hoa;
        }

        @Override
        public String toString() {
                return "KhoiA [toan=" + toan + ", ly=" + ly + ", hoa=" + hoa + ", soBaoDanh=" + super.getSoBaoDanh() + ", mucUuTien="
                                + super.getMucUuTien() + ", hoTen=" + super.getHoTen() + ", diaChi="
                                + super.getDiaChi() + "]";
        }

}

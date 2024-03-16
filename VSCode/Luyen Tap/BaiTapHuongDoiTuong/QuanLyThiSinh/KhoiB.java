package QuanLyThiSinh;

public class KhoiB extends ThiSinh {
        private int toan, hoa, sinh;

        public KhoiB(int soBaoDanh, int mucUuTien, String hoTen, String diaChi, int toan, int hoa, int sinh) {
                super(soBaoDanh, mucUuTien, hoTen, diaChi);
                this.toan = toan;
                this.hoa = hoa;
                this.sinh = sinh;
        }

        public int getToan() {
                return toan;
        }

        public void setToan(int toan) {
                this.toan = toan;
        }

        public int getHoa() {
                return hoa;
        }

        public void setHoa(int hoa) {
                this.hoa = hoa;
        }

        public int getSinh() {
                return sinh;
        }

        public void setSinh(int sinh) {
                this.sinh = sinh;
        }

        @Override
        public String toString() {
                return "KhoiB [toan=" + toan + ", hoa=" + hoa + ", sinh=" + sinh + ", soBaoDanh=" + super.getSoBaoDanh()
                                + ", mucUuTien="
                                + super.getMucUuTien() + ", hoTen=" + super.getHoTen() + ", diaChi="
                                + super.getDiaChi() + "]";
        }

}

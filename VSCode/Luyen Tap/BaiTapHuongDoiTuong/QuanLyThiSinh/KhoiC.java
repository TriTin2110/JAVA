package QuanLyThiSinh;

public class KhoiC extends ThiSinh {
        private int van, su, dia;

        public KhoiC(int soBaoDanh, int mucUuTien, String hoTen, String diaChi, int van, int su, int dia) {
                super(soBaoDanh, mucUuTien, hoTen, diaChi);
                this.van = van;
                this.su = su;
                this.dia = dia;
        }

        public int getVan() {
                return van;
        }

        public void setVan(int van) {
                this.van = van;
        }

        public int getSu() {
                return su;
        }

        public void setSu(int su) {
                this.su = su;
        }

        public int getDia() {
                return dia;
        }

        public void setDia(int dia) {
                this.dia = dia;
        }

        @Override
        public String toString() {
                return "KhoiC [van=" + van + ", su=" + su + ", dia=" + dia + ", soBaoDanh=" + super.getSoBaoDanh()
                                + ", mucUuTien="
                                + super.getMucUuTien() + ", hoTen=" + super.getHoTen() + ", diaChi="
                                + super.getDiaChi() + "]";
        }

}

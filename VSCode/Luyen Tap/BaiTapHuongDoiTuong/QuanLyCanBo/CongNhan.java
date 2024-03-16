package QuanLyCanBo;

public class CongNhan extends CanBo {
        private int Bac;

        public CongNhan(String hoTen, String diaChi, int tuoi, boolean gioiTinh, int bac) {
                super(hoTen, diaChi, tuoi, gioiTinh);
                Bac = bac;
        }

        public int getBac() {
                return Bac;
        }

        public void setBac(int bac) {
                Bac = bac;
        }

        @Override
        public String toString() {
                return "CongNhan [Bac=" + Bac + ", hoTen=" + super.getHoTen() + ", tuoi=" + super.getTuoi()
                                + ", diaChi=" + super.getDiaChi() + ", gioiTinh=" + super.isGioiTinh()+"]";
        }

}

package QuanLyCanBo;

public class NhanVien extends CanBo {
        private String congViec;

        public NhanVien(String hoTen, String diaChi, int tuoi, boolean gioiTinh, String congViec) {
                super(hoTen, diaChi, tuoi, gioiTinh);
                this.congViec = congViec;
        }

        public String getCongViec() {
                return congViec;
        }

        public void setCongViec(String congViec) {
                this.congViec = congViec;
        }

        @Override
        public String toString() {
                return "NhanVien [congViec=" + congViec + ", hoTen=" + super.getHoTen() + ", tuoi=" + super.getTuoi()
                                + ", diaChi=" + super.getDiaChi() + ", gioiTinh=" + super.isGioiTinh() + "]";
        }

}

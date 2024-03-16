package QuanLyCanBo;

public class KySu extends CanBo {
        private String nganhDaoTao;

        public KySu(String hoTen, String diaChi, int tuoi, boolean gioiTinh, String nganhDaoTao) {
                super(hoTen, diaChi, tuoi, gioiTinh);
                this.nganhDaoTao = nganhDaoTao;
        }

        public String getNganhDaoTao() {
                return nganhDaoTao;
        }

        public void setNganhDaoTao(String nganhDaoTao) {
                this.nganhDaoTao = nganhDaoTao;
        }

        @Override
        public String toString() {
                return "KySu [nganhDaoTao=" + nganhDaoTao + ", hoTen=" + super.getHoTen() + ", tuoi=" + super.getTuoi()
                                + ", diaChi=" + super.getDiaChi() + ", gioiTinh=" + super.isGioiTinh() + "]";
        }

}

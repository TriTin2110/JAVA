package QuanLyCanBo;

public class CanBo {
        private String hoTen, diaChi;
        private int tuoi;
        private boolean gioiTinh;

        public CanBo() {
        }

        public CanBo(String hoTen, String diaChi, int tuoi, boolean gioiTinh) {
                this.hoTen = hoTen;
                this.diaChi = diaChi;
                this.tuoi = tuoi;
                this.gioiTinh = gioiTinh;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public String getDiaChi() {
                return diaChi;
        }

        public void setDiaChi(String diaChi) {
                this.diaChi = diaChi;
        }

        public int getTuoi() {
                return tuoi;
        }

        public void setTuoi(int tuoi) {
                this.tuoi = tuoi;
        }

        public boolean isGioiTinh() {
                return gioiTinh;
        }

        public void setGioiTinh(boolean gioiTinh) {
                this.gioiTinh = gioiTinh;
        }

        @Override
        public String toString() {
                return "CanBo [hoTen=" + hoTen + ", diaChi=" + diaChi + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh
                                + "]";
        }

        
}

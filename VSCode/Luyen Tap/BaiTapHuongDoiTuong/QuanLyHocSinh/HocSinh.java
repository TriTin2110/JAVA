package QuanLyHocSinh;

public class HocSinh {
        private String hoTen, queQuan;
        private int tuoi;
        private Lop lop;

        public HocSinh(String hoTen, String queQuan, int tuoi, Lop lop) {
                this.hoTen = hoTen;
                this.queQuan = queQuan;
                this.tuoi = tuoi;
                this.lop = lop;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public String getQueQuan() {
                return queQuan;
        }

        public void setQueQuan(String queQuan) {
                this.queQuan = queQuan;
        }

        public int getTuoi() {
                return tuoi;
        }

        public void setTuoi(int tuoi) {
                this.tuoi = tuoi;
        }

        public Lop getLop() {
                return lop;
        }

        public void setLop(Lop lop) {
                this.lop = lop;
        }

        @Override
        public String toString() {
                return "HocSinh [hoTen=" + hoTen + ", queQuan=" + queQuan + ", tuoi=" + tuoi + ", lop=" + lop.toString()
                                + "]";
        }

}

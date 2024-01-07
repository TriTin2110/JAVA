public class TacGia {
        private Ngay ngay;
        private String tacGia;

        public TacGia(Ngay ngay, String tacGia) {
                this.ngay = ngay;
                this.tacGia = tacGia;
        }

        public void setTacGia(String tacGia) {
                this.tacGia = tacGia;
        }
        public String getTacGia() {
                return tacGia;
        }
}

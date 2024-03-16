public class HangPhim {
        private String tenHangPhim, quocGia;

        public HangPhim(String hangPhim, String quocGia) {
                this.tenHangPhim = hangPhim;
                this.quocGia = quocGia;
        }
        
        public String getTenHangPhim() {
                return tenHangPhim;
        }
        public void setTenHangPhim(String tenHangPhim) {
                this.tenHangPhim = tenHangPhim;
        }

        public String getQuocGia() {
                return quocGia;
        }
        public void setQuocGia(String quocGia) {
                this.quocGia = quocGia;
        }
}

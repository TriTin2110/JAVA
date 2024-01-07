public class hocSinh extends ConNguoi {
        private String tenTruong, tenLop;

        public hocSinh(String hoVaTen, int namSinh, String tenTruong, String tenLop) {
                super(hoVaTen, namSinh);
                this.tenLop = tenLop;
                this.tenTruong = tenTruong;
        }

        public String getTenLop() {
                return tenLop;
        }

        public void setTenLop(String tenLop) {
                this.tenLop = tenLop;
        }

        public String getTenTruong() {
                return tenTruong;
        }

        public void setTenTruong(String tenTruong) {
                this.tenTruong = tenTruong;
        }

        /**
         * lamBT
         */
        public void lamBT() {
                System.out.println("Làm BT");
        }

        /**
         * inThongTinHocSinh()
         */
        public String inThongTinHocSinh() {
                return getHoVaTen()+"\n"+getNamSinh()+"\n"+getTenTruong()+"\n"+getTenLop();
        }
}

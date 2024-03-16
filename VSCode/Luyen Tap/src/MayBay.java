public class MayBay extends LoaiPhuongTien {
        public MayBay(String tenNhienLieu, HangSanXuat hangSanXuat) {
                super(tenNhienLieu, hangSanXuat);
        }

        /**
         * catCanh()
         */
        public void catCanh() {
                System.out.println("Cất cánh....");
        }

        public void haCanh() {
                System.out.println("Hạ cánh....");
        }

        /**
         * tinhVanToc()
         */
        public double tinhVanToc(double vanToc) {
                return vanToc;
        }
}

public abstract class LoaiPhuongTien {
        private String tenNhienLieu;
        protected HangSanXuat hangSanXuat;
        public LoaiPhuongTien(String tenNhienLieu, HangSanXuat hangSanXuat) {
                this.tenNhienLieu = tenNhienLieu;
                this.hangSanXuat = hangSanXuat;
        }

        public String getTenNhienLieu() {
                return tenNhienLieu;
        }

        public void setTenNhienLieu(String tenNhienLieu) {
                this.tenNhienLieu = tenNhienLieu;
        }

        
        /**
         * InnerLoaiPhuongTien
         */
        public abstract double tinhVanToc(double vanToc);

        public HangSanXuat getHangSanXuat() {
                return hangSanXuat;
        }

        public void setHangSanXuat(HangSanXuat hangSanXuat) {
                this.hangSanXuat = hangSanXuat;
        }
}

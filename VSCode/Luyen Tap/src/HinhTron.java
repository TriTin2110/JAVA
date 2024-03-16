public class HinhTron extends Hinh {
        private double r;
        public HinhTron(double r) {
                this.r = r;
        }
        @Override
        public double tinhDienTich() {
                return Math.PI * Math.pow(r, 2);
        }

        
}

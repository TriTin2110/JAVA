package QuanLyHocSinh;

public class Lop {
        String tenLop;

        public Lop(String tenLop) {
                this.tenLop = tenLop;
        }

        public String getTenLop() {
                return tenLop;
        }

        public void setTenLop(String tenLop) {
                this.tenLop = tenLop;
        }

        @Override
        public String toString() {
                return "Lop [tenLop=" + tenLop + "]";
        }

        
}

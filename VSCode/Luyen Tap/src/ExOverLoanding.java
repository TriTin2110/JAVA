public class ExOverLoanding {

        /*
         * OverLoading nghĩa là phương thức có cùng tên nhưng khác nhau về mặc tham số
         * và giá trị trả về
         */
        /**
         * timMin(int a, int b)
         */
        public int timMin(int a, int b) {
                return Math.min(a, b);
        }

        /**
         * timMin(double a , double b)
         */
        public double timMin(double a, double b) {
                return Math.min(a, b);
        }

        /**
         * tinhTong(int mang[])
         */
        public double tinhTongMang(int mang[]) {
                double tong = 0;
                for (int i : mang) {
                        tong += i;
                }
                return tong;
        }

        /**
         * tinhTong(double a, double b)
         */
        public double tinhTong(double a, double b) {
                return a + b;
        }
}

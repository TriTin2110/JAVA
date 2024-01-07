public class MainTruuTuong {
        public static void main(String[] args) {
                Hinh h1 = new HinhTron(10);
                Hinh h2 = new HinhChuNhat(5, 10);

                System.out.println(h1.tinhDienTich());
                System.out.println(h2.tinhDienTich());
        }
}

package ArrowFunction;

public class MainDienTichChuNhat {
        public static void main(String[] args) {
                DienTichChuNhat dt = (a, b) ->{
                        return a * b;
                };
                System.out.println(dt.dienTichChuNhat(5, 10));
        }
}

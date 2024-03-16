/**
 * BangCuuChuong
 */
public class BangCuuChuong {

        public static void main(String[] args) {
                out: for (int i = 2; i < 10; i++) {
                        if (i%2 == 0) {
                                continue out;
                        }
                        in: for (int j = 1; j < 11; j++) {
                                System.out.println(i+" x "+j+ " = "+(i*j));
                        }
                        System.out.println("-----------------");
                }
        }
}
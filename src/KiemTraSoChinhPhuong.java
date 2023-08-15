import java.util.Scanner;

/**
 * KiemTraSoChinhPhuong
 */
public class KiemTraSoChinhPhuong {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số nguyên không hợp lệ!");
                        return;
                }

                System.out.println((kiemTraSoChinhPhuong(n)) ? "Yes" : "No");
                sc.close();
        }

        /**
         * kiemTraSoChinhPhuong(int n)
         */
        public static boolean kiemTraSoChinhPhuong(int n) {
                double soChinhPhuong = Math.sqrt(n);
                if ((soChinhPhuong - Math.ceil(soChinhPhuong)) == 0) {
                        return true;
                } else {
                        return false;
                }
        }
}
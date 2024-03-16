import java.util.Scanner;

/**
 * SoArmsStrong
 */
public class SoArmsStrong {

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
                kiemTraSoArmsStrong(n);
                sc.close();
        }

        /**
         * kiemTraSoArmsStrong(int n)
         */
        public static void kiemTraSoArmsStrong(int n) {
                String chuoi = Integer.toString(n);
                int tong = 0;
                int banDau = n;
                int dem = chuoi.length();
                while (n != 0) {
                        if (n < 10) {

                                tong += Math.pow(n, dem);
                                n /= 10;
                        } else {
                                tong += Math.pow((n % 10), dem);
                                n /= 10;
                        }
                }
                System.out.println((tong == banDau)
                                ? "Yes"
                                : "No");
        }
}
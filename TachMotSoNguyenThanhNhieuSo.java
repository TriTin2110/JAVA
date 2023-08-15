import java.util.Scanner;

/**
 * TachMotSoNguyenThanhNhieuSo
 */
public class TachMotSoNguyenThanhNhieuSo {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 chữ số bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số nguyên vừa nhập không hợp lệ!");
                        return;
                }
                tachSo(n);
                sc.close();
        }

        /**
         * tachSo(int n)
         */
        public static void tachSo(int n) {
                String chuoi = "";
                while (n != 0) {

                        if (n < 10) {
                                chuoi += n;
                                break;
                        } else {
                                chuoi = chuoi + (n / 10);
                        }
                        n %= 10;
                }
                char[] kyTu = chuoi.toCharArray();
                for (int i = 0; i < kyTu.length; i++) {
                        System.out.println(kyTu[i]);
                }
        }
}
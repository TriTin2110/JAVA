import java.util.Scanner;

public class TinhTongCacSoTuNhien {
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
                tinhTong(n);
                sc.close();
        }
        /**
         * tinhTong(int n)
         */
        public static void tinhTong(int n) {
                int tong = 0;
                for (int i = 1; i <= n; i++) {
                        tong+=i;
                }
                System.out.println("Tổng của các số từ 0 ->"+n+" là: "+tong);
        }
}

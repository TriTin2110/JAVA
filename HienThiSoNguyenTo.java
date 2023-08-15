import java.util.Scanner;

public class HienThiSoNguyenTo {
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
                inSoNguyenTo(n);
                sc.close();
        }

        /**
         * inSoNguyenTo(int n)
         */
        public static void inSoNguyenTo(int n) {
                boolean check = true;
                String soNguyenTo = "";
                if (n == 1) {
                        System.out.println(1);
                } else {
                        out: for (int i = 2; i <= n; i++) {
                                check = true;
                                in: for (int j = 2; j < i; j++) {
                                        if (i % j != 0) { /*
                                                           * Chia i lần lượt cho j nếu như số dư khác 0 thì
                                                           * sẽ chuyển sang số tiếp theo còn trường hợp ngược lại
                                                           * thì cho check = false và continue sang số i mới
                                                           */
                                                continue in;
                                        } else {
                                                check = false;
                                                continue out;
                                        }
                                }
                                if (check) {
                                        soNguyenTo += i + "\n";
                                }
                        }
                        System.out.println(soNguyenTo);
                }
        }
}
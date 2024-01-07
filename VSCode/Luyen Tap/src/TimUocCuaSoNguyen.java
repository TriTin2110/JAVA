import java.util.Scanner;

public class TimUocCuaSoNguyen {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị số vừa nhập không hợp lệ!");
                        return;
                }
                timUoc(n);
                sc.close();
        }
        /**
         * timUoc(int n)
         */
        public static void timUoc(int n) {
                System.out.println("Ước của "+n+" là:");
                for (int i = 1; i <= n; i++) {
                        if (n % i == 0) {
                               System.out.print(i+"\t");
                        }
                }
        }
}

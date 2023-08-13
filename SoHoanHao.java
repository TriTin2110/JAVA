import java.util.Scanner;

public class SoHoanHao {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);

                } catch (Exception e) {
                        System.out.println("Giá trị vừa nhập không hợp lệ!");
                        return;
                }
                kiemTra(n);
                sc.close();
        }

        /**
         * kiemTra(int n)
         */
        public static void kiemTra(int n) {
                int tong = 0;
                for (int i = 1; i < n; i++) {
                        if (n % i == 0) {
                                tong += i;
                        }
                }
                System.out.println((tong == n)
                                ? "Số vừa nhập là số hoàn hảo!"
                                : "Số vừa nhập không phải là số hoàn hảo!");
        }
}

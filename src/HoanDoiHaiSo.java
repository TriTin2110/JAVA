import java.util.Scanner;

public class HoanDoiHaiSo {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int a, b;
                try {
                        do {
                                System.out.println("Hãy nhập số a: ");
                                a = sc.nextInt();
                        } while (a < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị a không hợp lệ!");
                        return;
                }
                try {
                        do {
                                System.out.println("Hãy nhập giá trị b: ");
                                b = sc.nextInt();
                        } while (b < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị b không hợp lệ: ");
                        return;
                }
                hoanDoiHaiSo(a, b);
                sc.close();
        }

        /**
         * hoanDoiHaiSo(int a, int b)
         */
        public static void hoanDoiHaiSo(int a, int b) {
                int temp = a;
                a = b;
                b = temp;
                System.out.println("Giá trị a là: " + a);
                System.out.println("Giá trị b là: " + b);

        }
}

import java.util.Scanner;

/**
 * TimBoiChungNhoNhat
 */
public class UocChungLonNhat {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int a, b;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị a: ");
                                a = sc.nextInt();
                        } while (a < 0);
                } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Giá trị của phần tử a không hợp lệ!");
                        sc.close();
                        return;
                }
                try {
                        do {
                                System.out.println("Hãy nhập giá trị b: ");
                                b = sc.nextInt();
                        } while (b < 0);
                } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Giá trị của phần tử b không hợp lệ!");
                        sc.close();
                        return;
                }
                outPut(a, b);
                sc.close();
        }

        /**
         * outPut()
         */
        static void outPut(int a, int b) {
                int soNhoNhat = (a < b) ? a : b;
                int kq = 0;
                for (int i = soNhoNhat; i >= 1; i--) {
                        if (a % i == 0 && b % i == 0) {
                                kq = i;
                                break;
                        }
                }
                System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + kq);
        }
}
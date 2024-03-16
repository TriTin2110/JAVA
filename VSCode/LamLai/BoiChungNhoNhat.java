import java.util.Scanner;

public class BoiChungNhoNhat {
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
                        System.out.println("Giá trị a không hợp lệ!");
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
                        System.out.println("Giá trị b không hợp lệ!");
                        sc.close();
                        return;
                }
                output(a, b);
                sc.close();
        }

        /**
         * output(int a, itn b)
         */
        static void output(int a, int b) {
                int soLonNhat = (a > b) ? a : b;
                while (true) {
                        if (soLonNhat % a == 0 && soLonNhat % b == 0) {
                                break;
                        }
                        soLonNhat++;
                }
                System.out.println(soLonNhat);
        }
}

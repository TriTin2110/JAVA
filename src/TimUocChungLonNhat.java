import java.util.Scanner;

public class TimUocChungLonNhat {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int a, b;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị a: ");
                                a = sc.nextInt();
                        } while (a == 0);
                        do {
                                System.out.println("Hãy nhập giá trị b: ");
                                b = sc.nextInt();
                        } while (b == 0);
                } catch (Exception e) {
                        System.out.println("Giá trị nhập vào không hợp lệ!");
                        return;
                }
                timUocChungLonNhat(a, b);
                sc.close();
        }

        /**
         * timUocChungLonNhat(int a, int b)
         */
        public static void timUocChungLonNhat(int a, int b) {
                int soNhoNhat = (a>b)?b:a;
                int uocChungLonNhat = soNhoNhat;
                while (true) {
                        if (a % uocChungLonNhat == 0 && b% uocChungLonNhat == 0) {
                                System.out.println(uocChungLonNhat);
                                return;
                        }
                        uocChungLonNhat--;
                }
        }
}

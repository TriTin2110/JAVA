import java.util.Scanner;

/**
 * TimBoiChungNhoNhat
 */
public class TimBoiChungNhoNhat {
        // Số nhỏ nhất chia hết cho 2 số đã nhập
        // int a, b, boiChungNhoNhat, dem
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int a, b;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị a: ");
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
                        System.out.println("Giá trị b không hợp lệ!");
                        return;
                }
                timBoiChungNhoNhat(a, b);
                sc.close();
        }

        /**
         * timBoiChungNhoNhat(int a, int b)
         */
        public static void timBoiChungNhoNhat(int a, int b) {
                int boiChungNhoNhat = (a > b) ? a : b;
                do {
                        if (boiChungNhoNhat % a == 0 && boiChungNhoNhat % b == 0) {
                                break;
                        }
                        boiChungNhoNhat++;
                } while (boiChungNhoNhat % a != 0 || boiChungNhoNhat % b != 0);
                System.out.println(boiChungNhoNhat);
        }
}
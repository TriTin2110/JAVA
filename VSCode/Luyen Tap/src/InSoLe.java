import java.util.Scanner;

public class InSoLe {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng phần tử: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của phần tử không hợp lệ");
                        return;
                }
                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        try {
                                do {
                                        System.out.println("Hãy nhập giá trị cho phần tử thứ " + (i + 1) + ": ");
                                        mang[i] = sc.nextInt();
                                } while (mang[i] == 0);
                        } catch (Exception e) {
                                System.out.println("Giá trị của phần tử không hợp lệ!");
                                return;
                        }
                }
                inSoLe(mang);
                sc.close();
        }

        /**
         * inSoLe(int[] mang)
         */
        public static void inSoLe(int[] mang) {
                for (int i : mang) {
                        if (i % 2 != 0) {
                                System.out.println(i);
                        }
                }
        }
}

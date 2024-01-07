import java.util.Scanner;

public class TimSoLonNhatTrongMang {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                // int n;
                // try {
                // do {
                // System.out.println("Hãy nhập số phần tử có trong mảng: ");
                // n = sc.nextInt();
                // } while (n < 1);
                // } catch (Exception e) {
                // System.out.println("Số lượng phần tử không hợp lệ!");
                // return;
                // }
                // int[] mang = new int[n];
                // for (int i = 0; i < mang.length; i++) {
                // System.out.println("Hãy nhập giá trị của phần tử thứ "+(i+1)+": ");
                // mang[i] = sc.nextInt();
                // }
                // System.out.println(inSoLonNhat(mang));
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng phần tử: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Số lượng phần tử không hợp lệ!");
                        return;
                }
                System.out.println("\nSố lớn nhất trong mảng là: " + inSoLonNhat(n));
                sc.close();
        }

        /**
         * inSoLonNhat(int[] mang)
         */
        // public static int inSoLonNhat(int[] mang) {
        // int soLonNhat = 0;
        // for (int i : mang) {
        // if (soLonNhat < i) {
        // soLonNhat = i;
        // }
        // }
        // return soLonNhat;
        // }
        /**
         * inSoLonNhat()
         */
        public static int inSoLonNhat(int n) {
                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        mang[i] = (int) (Math.random() * 100);
                }
                for (int i = 0; i < mang.length; i++) {
                        System.out.print(mang[i] + "\t");
                        if ((i+1) % 10 == 0) {
                                System.out.println();
                        }

                }
                int soLonNhat = 0;
                for (int i : mang) {
                        if (soLonNhat < i) {
                                soLonNhat = i;
                        }
                }
                return soLonNhat;
        }
}

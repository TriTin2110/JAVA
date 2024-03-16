import java.util.Scanner;

public class TimSoLonNhat {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
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

                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        try {
                                System.out.println("Hãy nhập phần tử thứ " + (i + 1) + ": ");
                                mang[i] = sc.nextInt();
                        } catch (Exception e) {
                                System.out.println("Giá trị của phần tử không hợp lệ!");
                                return;
                        }
                }
                inSoLonNhat(mang);
                sc.close();
        }

        /**
         * inMang(int[] mang)
         */
        public static void inSoLonNhat(int[] mang) {
                int soLonNhat = 0;
                for (int i = 0; i < mang.length - 1; i++) {
                        for (int j = i + 1; j < mang.length; j++) {
                                mang[j] = Math.max(mang[j], mang[i]);
                                soLonNhat = Math.max(soLonNhat, mang[j]);
                        }
                }
                System.out.println(soLonNhat);
        }

}

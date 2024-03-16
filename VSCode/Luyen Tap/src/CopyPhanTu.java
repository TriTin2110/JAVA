import java.util.Scanner;

public class CopyPhanTu {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng phần tử của mảng: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Số lượng phần tử của mảng không hợp lệ!");
                        return;
                }
                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        System.out.println("Hãy nhập giá trị của phần tử thứ "+(i+1)+": ");
                        mang[i] = sc.nextInt();
                }
                inKetQua(mang);
                sc.close();
        }
        /**
         * inKetQua(int[] mang)
         */
        public static void inKetQua(int[] mang) {
                int[] mangKQ = new int[mang.length];
                for (int i = 0; i < mang.length; i++) {
                        mangKQ[i] = mang[i];
                }
                for (int i : mangKQ) {
                        System.out.println(i);
                }
        }
}

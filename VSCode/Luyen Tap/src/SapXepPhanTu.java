import java.util.Scanner;

public class SapXepPhanTu {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số phần tử có trong mảng: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Số lượng phần tử không hợp lệ!");
                        return;
                }
                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        try {
                                System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
                                mang[i] = sc.nextInt();
                        } catch (Exception e) {
                                System.out.println("Giá trị của phần tử không hợp lệ!");
                                return;
                        }
                }
                sapXepPhanTuTangDan(mang);
                sc.close();
        }

        /**
         * sapXepPhanTuTangDan(int[] phanTu)
         */
        public static void sapXepPhanTuTangDan(int[] phanTu) {
                for (int i = 0; i < phanTu.length-1; i++) {
                        for (int j = i+1; j < phanTu.length; j++) {
                                if (phanTu[i]>phanTu[j]) {
                                        phanTu[i] = hoanDoi(phanTu[j], phanTu[j] = phanTu[i]);
                                }
                        }
                }
                for (int i = 0; i < phanTu.length; i++) {
                        System.out.println(phanTu[i]);
                }
        }

        /**
         * hoanDoi(int a, int b)
         */
        public static int hoanDoi(int a, int b) {
                return a;
        }
}

import java.util.Scanner;

/**
 * DaoNguocCacPhanTuTrongMang
 */
public class DaoNguocCacPhanTuTrongMang {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng các phần tử có trong mảng: ");
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
                daoNguoc(mang);
                sc.close();
        }

        /**
         * hoanDoi(int[] mang)
         */
        public static void daoNguoc(int[] mang) {
                int viTri = 1;
                out: for (int i = 0; i <= mang.length / 2; i++) {
                        for (int j = mang.length - viTri; j >= mang.length / 2; j++) {
                                mang[i] = hoanDoi(mang[mang.length - viTri], mang[mang.length - viTri] = mang[i]);
                                viTri++;
                                continue out;
                        }
                }
                for (int i = 0; i < mang.length; i++) {
                        System.out.print(mang[i] + ", ");
                }
        }

        /**
         * hoanDoi(int a, int b)
         */
        public static int hoanDoi(int a, int b) {
                return a;
        }
}
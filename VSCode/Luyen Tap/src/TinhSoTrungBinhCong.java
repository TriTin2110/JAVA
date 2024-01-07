import java.util.Scanner;

/**
 * TinhSoTrungBinhCong
 */
public class TinhSoTrungBinhCong {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng các phần tử có trong mảng: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Số lượng các phần tử trong mảng không hợp lệ!");
                        return;
                }
                double[] mang = new double[n];
                for (int i = 0; i < mang.length; i++) {
                        try {
                                System.out.println("Hãy nhập giá trị của phần tử thứ "+(i+1)+": ");
                                mang[i] = sc.nextDouble();
                        } catch (Exception e) {
                                System.out.println("Giá trị của phần tử không hợp lệ: ");
                                return;
                        }
                }
                tinhSoTrungBinhCong(mang);
                sc.close();
        }
        /**
         * tinhSoTrungBinhCong(int[] mang)
         */
        public static void tinhSoTrungBinhCong(double[] mang) {
                double tong = 0;
                for (int i = 0; i < mang.length; i++) {
                        tong+=mang[i];
                }
                System.out.println("Trung bình cộng của các số vừa nhập là: "+(tong/mang.length));
        }
}
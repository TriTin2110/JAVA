import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SoNgauNhienTrungLap {
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
                timSoTrungLap(n);
                sc.close();
        }

        /**
         * timSoTrungLap(int n)
         */
        public static void timSoTrungLap(int n) {
                int[] mang = new int[n];
                for (int i = 0; i < mang.length; i++) {
                        mang[i] = (int) (Math.random() * 100);
                }
                int[] soTrungLap = new int[n];
                for (int i = 0; i < soTrungLap.length; i++) {
                        System.out.print(mang[i] + "\t");
                        if ((i + 1) % 10 == 0) {
                                System.out.println();
                        }
                }
                int dem = 0;
                out: for (int i = 0; i < mang.length - 1; i++) {
                        for (int j = 0; j < soTrungLap.length; j++) {
                                if (mang[i] == soTrungLap[j])
                                        continue out;
                        }
                        for (int j = i + 1; j < soTrungLap.length; j++) {
                                if (mang[i] == mang[j]) {
                                        System.out.println("Những số trùng lặp là: " + mang[i]);
                                        soTrungLap[dem] = mang[i];
                                        dem++;
                                }
                        }
                }
        }
}

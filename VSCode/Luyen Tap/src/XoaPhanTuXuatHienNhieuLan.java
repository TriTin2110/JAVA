import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class XoaPhanTuXuatHienNhieuLan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                // int n;

                // try {
                //         do {
                //                 System.out.println("Hãy nhập số lượng phần tử trong mảng: ");
                //                 n = sc.nextInt();
                //         } while (n < 1);
                // } catch (Exception e) {
                //         System.out.println("Số lượng phần tử không hợp lệ");
                //         return;
                // }
                int[] mang = {1, 3, 3};
                // for (int i = 0; i < mang.length; i++) {
                //         System.out.println("Hãy nhập giá trị thứ " + (i + 1) + ": ");
                //         mang[i] = sc.nextInt();
                // }
                timPhanTuTrungLap(mang);
                sc.close();
        }

        /**
         * timPhanTuTrungLap(int[] mang)
         */
        public static void timPhanTuTrungLap(int[] mang) {
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                int j = 0;
                int h = 0;
                int[] temp = new int[mang.length];
                for (Integer i : mang) {
                        if (map.containsKey(i)) {
                                temp[j] = i;
                                h++;
                                j++;
                        } else {
                                map.put(i, 1);
                        }
                }
                
                for (int i = 0; i < temp.length-(h+1); i++) {
                        System.out.println(temp[i]);
                }
                System.out.println("\n-------\n");
                int soLanTrungLap = 0;
                for (int i = 0; i < mang.length; i++) {
                        for (int k = 0; k < temp.length; k++) {
                                if (mang[i] == temp[k]) {
                                        mang[i] = 0;
                                }
                        }
                }
                for (int i = 0; i < mang.length; i++) {
                        if (mang[i] != 0) {
                                System.out.println(mang[i]);
                        }
                }
        }
}

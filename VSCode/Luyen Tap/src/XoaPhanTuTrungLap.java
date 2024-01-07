import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class XoaPhanTuTrungLap {
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
                        System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
                        mang[i] = sc.nextInt();
                }
                timPhanTuTrungLap(mang);
                sc.close();
        }

        /**
         * timPhanTuTrungLap(int[] mang)
         */
        public static void timPhanTuTrungLap(int[] mang) {
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int i : mang) {
                        if (map.containsKey(i)) {
                                map.put(i, map.get(i) + 1);
                        } else {
                                map.put(i, 1);
                        }
                }

                Set<Integer> key = map.keySet();
                for (Integer integer : key) {
                        if (map.get(integer) > 0) {
                                System.out.println(integer);
                        }
                }
        }
}

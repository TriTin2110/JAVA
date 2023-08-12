import java.util.Arrays;
import java.util.Scanner;

public class InPhanTuTrongMan {
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
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                        System.out.println("Hãy nhập phần tử thứ "+(i+1)+": ");
                        arr[i] = sc.nextInt();
                }
                sapXepPhanTu(arr);
                sc.close();
        }

        /**
         * sapXepPhanTu(int[] arr)
         */
        public static void sapXepPhanTu(int[] arr) {
                for (int i = 0; i < arr.length-1; i++) {
                        for (int j = i+1; j < arr.length; j++) {
                                if (arr[i]>arr[j]) {
                                        arr[i] = hoanDoi(arr[j], arr[j] = arr[i]);
                                }
                        }
                }
                for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                }
                
        }
        /**
         * hoanDoi(int a, int b)
         */
        public static int hoanDoi(int a, int b) {
                return a;
        }
}

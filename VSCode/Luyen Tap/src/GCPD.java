import java.util.ArrayList;

public class GCPD {
        public static void main(String[] args) {
                greatestCommonPrimeDivisor(12, 18);
        }

        static int greatestCommonPrimeDivisor(int a, int b) {
                int max = (a > b) ? b : a;
                ArrayList<Integer> arr = new ArrayList<>();
                // Xác định dãy số nguyên tố
                out: for (int i = 2; i < max; i++) {
                        if (i < 4)
                                arr.add(i);
                        else {
                                for (int j = 2; j < i; j++) {
                                        if (i % j == 0)
                                                continue out;
                                }
                                arr.add(i);
                        }
                }
                // Hiển thị ước số nguyên tố lớn nhất của hai giá trị a và b
                int result = -1;
                for (Integer ar : arr) {
                        if (a % ar == 0 && b % ar == 0)
                                result = ar;
                }
                return result;
        }

}

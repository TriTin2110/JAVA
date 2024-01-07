package CodeLearnThuatToan;

public class Bai6 {
        public static void main(String[] args) {
                int i = 1;
                System.out.println(digitsProduct(i));
        }

        private static int digitsProduct(int product) {
                int res = 0;
                int stt = 1;
                if (product == 1)
                        return 1;
                if (product == 0)
                        return 10;
                for (int i = 9; i >= 2; i--) {
                        while (product % i == 0) {
                                res = (i * stt) + res;
                                product /= i;
                                stt *= 10;
                        }
                }
                return (res != 0) ? res : -1;
        }
}

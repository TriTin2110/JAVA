/**
 * Hay cho biet co bao nhiu phan tu la uoc cua 2023
 */
public class cauE {
        public static void main(String[] args) {
                int n = 2023;
                int tong = 0;
                for (int i = 1; i <= 2023; i++) {
                        if (2023 % i == 0) {
                                System.out.println(i + " la uoc cua 2023");
                                tong++;
                        }
                }
                System.out.print("Co " + tong + " phan tu la uoc cua 2023");
        }
}
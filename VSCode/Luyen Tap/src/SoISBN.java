import java.util.Scanner;

public class SoISBN {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int[] mang = new int[10];
                for (int i = 0; i < mang.length; i++) {
                        System.out.println("Hãy nhập giá trị thứ " + (i + 1) + ": ");
                        mang[i] = sc.nextInt();
                }
                // 8175257660
                tinhSoISBN(mang);
                sc.close();
        }

        /**
         * tinhSoISBN(int[] mang)
         */
        public static void tinhSoISBN(int[] mang) {
                int SoISBN = 0;
                int viTri = 1;
                out: for (int i = 1; i <= 10; i++) {
                        for (int j = mang.length - viTri; j >= 0; j++) {
                                SoISBN += mang[j] * i;
                                viTri++;
                                continue out;
                        }
                }
                System.out.println((SoISBN % 11 == 0)
                                ? "Số vừa nhập là số ISBN!"
                                : "Số vừa nhập không phải là số ISBN!");
        }
}

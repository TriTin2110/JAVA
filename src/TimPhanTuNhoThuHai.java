import java.util.Scanner;

public class TimPhanTuNhoThuHai {
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
                        System.out.println("Hãy nhập giá trị thứ " + (i + 1) + ": ");
                        mang[i] = sc.nextInt();
                }
                timPhanTu(mang);
                sc.close();
        }

        /**
         * timPhanTu(int[] mang)
         */
        public static void timPhanTu(int[] mang) {
                int phanTuNhoThuHai = 0; // phanTuNhoThuHai > soNhoNhat
                int soNhoNhat = 0;
                int ketQua = 0;
                for (int i = 0; i < mang.length - 1; i++) {
                        if (soNhoNhat == 0) {
                                soNhoNhat = mang[i];
                        }
                        soNhoNhat = Math.min(soNhoNhat, mang[i]);
                        for (int j = i + 1; j < mang.length; j++) {
                                if (phanTuNhoThuHai == 0) {
                                        phanTuNhoThuHai = mang[j];
                                }
                                if (mang[i] > soNhoNhat && mang[i] < mang[j]) { // Nếu số hiện tại lớn hơn số nhỏ nhất
                                                                                // trong mảng và nhỏ hơn số kế tiếp số
                                                                                // hiện tại thì
                                                                                // sẽ lấy số đó so sánh vs số nhỏ thứ 2

                                        phanTuNhoThuHai = Math.min(phanTuNhoThuHai, mang[i]);
                                }
                        }

                }
                System.out.println(phanTuNhoThuHai);
        }
}

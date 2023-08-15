import java.util.Scanner;

public class KiemTraDaySoArmsStrong {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị n: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số nguyên không hợp lệ!");
                        return;
                }
                kiemTraSoArmsStrong(n);
                sc.close();
        }

        /**
         * kiemTraSoArmsStrong(int n)
         */
        public static void kiemTraSoArmsStrong(int n) {
                for (int i = 10; i <= n; i++) {
                        int banDau = i;
                        int j = i;
                        String chuoi = Integer.toString(i);
                        int dem = chuoi.length();
                        int tong = 0;
                        while (j != 0) {
                                if (j < 10) {
                                        tong += Math.pow(j, dem);
                                        j/=10;
                                } else {
                                        tong += Math.pow((j % 10), dem);
                                        j /= 10;
                                }
                        }
                        if(tong == banDau)
                        {
                                System.out.println(i);
                        }
                }
        }
}

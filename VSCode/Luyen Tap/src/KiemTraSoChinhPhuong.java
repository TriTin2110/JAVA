import java.util.Scanner;

public class KiemTraSoChinhPhuong {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số nguyên không hợp lệ!");
                        return;
                }
                kiemTraSoChinhPhuong(n);
                sc.close();
        }

        /**
         * kiemTraSoChinhPhuong(int n)
         */
        public static void kiemTraSoChinhPhuong(int n) {
                double soChinhPhuong = Math.sqrt(n);
                System.out.println((Math.ceil(soChinhPhuong) - n > 0)
                                ? "Số vừa nhập là số chính phương"
                                : "Số vừa nhập không phải là số chính phương!");
        }
}

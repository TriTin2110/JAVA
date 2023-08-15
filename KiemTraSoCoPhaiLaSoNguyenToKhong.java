import java.util.Scanner;

public class KiemTraSoCoPhaiLaSoNguyenToKhong {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị số nguyên không hợp lệ!");
                        return;
                }
                kiemTraSoNguyenTo(n);
                sc.close();
        }

        /**
         * kiemTraSoNguyenTo(int n)
         */
        public static void kiemTraSoNguyenTo(int n) {
                boolean check = true;
                if (n == 1) {
                        System.out.println("Đây là số nguyên tố!");
                } else {
                        out: for (int i = 2; i < n; i++) {
                                if (n % i != 0) {
                                        continue out;
                                } else {
                                        check = false;
                                        break;
                                }
                        }
                        System.out.println((check)
                                        ? "Số vừa nhập là số nguyên tố"
                                        : "Số vừa nhập không phải là số nguyên tố");
                }

        }
}

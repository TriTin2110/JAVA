import java.util.Scanner;

public class timKiemTuyenTinh {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                        n = sc.nextInt();
                } catch (Exception e) {
                        System.out.println("Giá trị của số nguyên không hợp lệ!");
                        return;
                }
                int soNguyen;
                try {
                        System.out.println("Hãy nhập 1 số nguyên nằm trong dãy số ban đầu: ");
                        soNguyen = sc.nextInt();
                } catch (Exception e) {
                        System.out.println("Giá trị số nguyên không hợp lệ!");
                        return;
                }
                timKiem(n, soNguyen);
                sc.close();
        }

        /**
         * timKiem(int n)
         */
        public static void timKiem(int n, int soNguyen) {
                int check = 0;
                String chuoi = "";
                int[] mang = String.valueOf(Math.abs(n)).chars().map(c -> c - 48).toArray(); /*
                                                                                              * Arrow function
                                                                                              * c->c-48
                                                                                              * c là tham số
                                                                                              * c-48 là phương thức
                                                                                              */
                for (int i = 0; i < mang.length; i++) {
                        if (soNguyen == mang[i]) {
                                chuoi += i + "\t";
                                check++;
                        }
                }
                System.out.println((check > 0)
                                ? "Những vị trí mà giá trị " + soNguyen + " xuất hiện là: " + chuoi
                                : "Giá trị " + soNguyen + " không có trong danh sách!");
        }
}

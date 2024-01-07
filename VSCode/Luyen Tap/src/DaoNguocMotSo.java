import java.util.Scanner;

/**
 * DaoNguocMotSo
 */
public class DaoNguocMotSo {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số vừa nhập không hợp lệ!");
                        return;
                }
                daoNguocSo(n);
                sc.close();
        }
        /**
         * daoNguocSo(int n)
         */
        public static void daoNguocSo(int n) {
                String soDaoNguoc = "";
                while (n != 0) {
                        soDaoNguoc += (n%10) ;
                        n/=10;
                }
                System.out.println(soDaoNguoc);
        }
}
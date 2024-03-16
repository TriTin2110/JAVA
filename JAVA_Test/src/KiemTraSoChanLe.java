import java.util.Scanner;

/**
 * KiemTraSoChanLe
 */
public class KiemTraSoChanLe {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhap so nguyen bat ky: ");
                double a = sc.nextFloat();
                int check = kiemTraSoNguyen(a);
                if (check == 1) {
                        if (a % 2 == 0) {
                                System.out.println("So vua nhap la so chan!!");
                        } else {
                                System.out.println("So vua nhap la so le!!!");
                        }
                }

                else {
                        System.out.println("So vua nhap khong phai la so nguyen!!!");
                }
        }

        private static int kiemTraSoNguyen(double a) {
                int flag = 1;
                if (Math.ceil(a) != Math.floor(a)) /*
                                                    * Làm tròn 2 (Math.ceil là tròn lên, MAth.floor là tròn xuống) số
                                                    * sau đó so sánh chúng vs nhau
                                                    */
                        flag = 0;
                return flag;
        }
}
/**
 * InnerKiemTraSoChanLe
 */
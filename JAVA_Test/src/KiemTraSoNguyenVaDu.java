import java.util.Scanner;

/**
 * KiemTraSoNguyenVaDu
 */
public class KiemTraSoNguyenVaDu {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap so thu nhat: ");
                int a = sc.nextInt();
                System.out.print("Hay nhap so thu hai: ");
                int b = sc.nextInt();
                System.out.println("Hay chon phep tinh:");
                System.out.println("1. a/b");
                System.out.println("2. b/a");
                System.err.print("==> ");
                int check = sc.nextInt();
                switch (check) {
                        case 1:
                                System.out.println("Phan nguyen cua a/b la: " + a / b);
                                System.out.println("Phan du cua a/b la: " + a % b);
                                break;

                        default:
                                System.out.println("Phan nguyen cua b/a la: " + b / a);
                                System.out.println("Phan du cua b/a la: " + b % a);
                                break;
                }
        }
}
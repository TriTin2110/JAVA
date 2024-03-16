import java.util.Scanner;

/**
 * InnerCongHaiSo
 */
public class CongHaiSo {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap so thu 1: ");
                int a = sc.nextInt();
                System.out.print("Hay nhap so thu 2: ");
                int b = sc.nextInt();
                System.out.println("Tong cua hai so vua nhap la: " + (a + b));
        }
}
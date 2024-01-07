import java.util.Scanner;

/**
 * Ctr_cong_hai_so_Nguyen
 */
public class Ctr_cong_hai_so_Nguyen {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num1;
                System.out.print("Hay nhap so thu 1: ");
                num1 = scanner.nextInt();
                System.out.print("Hay nhap so thu 2: ");
                int num2 = scanner.nextInt();
                System.out.println("Tong cua " + num1 + " va " + num2 + " la: " + (num1 + num2));
        }
}
import java.util.Scanner;

/**
 * HienThi5SoNguyenTo
 */
public class HienThi5SoNguyenTo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap n so nguyen to dau tien: ");
        int n = scanner.nextInt();
        int num = 3;
        int kiemtra = 0;
        System.out.print(n + " so nguyen to dau tien la:\t");
        for (int i = 2; i <= n + 1;) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0)
                    kiemtra++;
            }
            if (kiemtra == 0) {
                System.out.print(num + "\t");
                i++;
            }
            num++;
            kiemtra = 0;
        }
    }
}
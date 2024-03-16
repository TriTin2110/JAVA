import java.util.Scanner;

/**
 * NhiPhan
 */
public class NhiPhan {
    public static void NhiPhan(int n) {
        if (n / 2 > 0) {
            NhiPhan(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("Hay nhap gia tri cua n bat ky: ");
        int n = scanner.nextInt();
        NhiPhan(n);
    }
}
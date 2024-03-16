import java.util.Scanner;

/**
 * KiemTraSoHoanHao
 */
public class KiemTraSoHoanHao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap 1 so nguyen duong bat ky: ");
        int n = scanner.nextInt();
        int kiemtra = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                kiemtra += i;
        }
        if (kiemtra == n)
            System.out.println(n + " la so hoan hao !!!");
        else
            System.out.println(n + " khong phai la so hoan hao !!!");
    }
}
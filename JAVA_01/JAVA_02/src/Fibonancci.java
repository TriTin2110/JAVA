import java.util.Scanner;

public class Fibonancci {
    public static int Fibonancci(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else
            return Fibonancci(n - 1) + Fibonancci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap gia tri cua n: ");
        int n = scanner.nextInt();
        System.out.println("Tong cua day so Fibonancci tu 0 -> " + n + " la: " + Fibonancci(n));
    }

}

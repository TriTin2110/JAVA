import java.util.Scanner;

public class BaitapJAVA1 {
    public static void main(String[] args) {
        int n;
        int chuc, donvi;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap 1 so nguyen bat ky: ");
        n = scanner.nextInt();
        chuc = n / 10;
        donvi = n % 10;
        if (chuc == 1) {
            System.out.println("Muoi");
        } else if (chuc > 1) {
            n = chuc;
            so(n);
            System.out.print(" Muoi ");
            n = donvi;
            if (n == 1)
                System.out.println("Mot");
            else
                so(n);
        }
        /*
         * if (n >= 90 && n < 100) {
         * System.out.print("Chin Muoi ");
         * n = n % 10;
         * }
         * if (n >= 80 && n < 90) {
         * System.out.print("Tam Muoi ");
         * n = n % 10;
         * }
         * if (n >= 70 && n < 80) {
         * System.out.print("Bay Muoi ");
         * n = n % 10;
         * }
         * if (n >= 60 && n < 70) {
         * System.out.print("Sau Muoi ");
         * n = n % 10;
         * }
         * if (n >= 50 && n < 60) {
         * System.out.print("Nam Muoi ");
         * n = n % 10;
         * }
         * if (n >= 40 && n < 50) {
         * System.out.print("Bon Muoi ");
         * n = n % 10;
         * }
         * if (n >= 30 && n < 40) {
         * System.out.print("Ba Muoi ");
         * n = n % 10;
         * }
         * if (n >= 20 && n < 30) {
         * System.out.print("Hai Muoi ");
         * n = n % 10;
         * }
         * if (n >= 10 && n < 20) {
         * System.out.print("Muoi ");
         * n = n % 10;
         * }
         */
        scanner.close();
    }

    public static void so(int n) {
        if (n == 2) {
            System.out.print("Hai");
        }
        if (n == 3) {
            System.out.print("Ba");
        }
        if (n == 4) {
            System.out.print("Bon");
        }
        if (n == 5) {
            System.out.print("Nam");
        }
        if (n == 6) {
            System.out.print("Sau");
        }
        if (n == 7) {
            System.out.print("Bay");
        }
        if (n == 8) {
            System.out.print("Tam");
        }
        if (n == 9) {
            System.out.print("Chin");
        }
    }
}

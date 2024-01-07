import java.lang.Math;
import java.util.Scanner;

public class ChungMinhTamGiacVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so nguyen thu 1: ");
        int sothu1 = scanner.nextInt();
        System.out.print("Hay nhap so nguyen thu 2: ");
        int sothu2 = scanner.nextInt();
        System.out.print("Hay nhap so nguyen thu 3: ");
        int sothu3 = scanner.nextInt();
        if (Math.pow(sothu1, 2) + Math.pow(sothu2, 2) == Math.pow(sothu3, 2)
                || Math.pow(sothu3, 2) + Math.pow(sothu2, 2) == Math.pow(sothu1, 2)
                || Math.pow(sothu1, 2) + Math.pow(sothu3, 2) == Math.pow(sothu2, 2))
            System.out.println("Day la 1 tam giac vuong");
        else
            System.out.println("Day khong phai la 1 tam giac vuong");

    }
}

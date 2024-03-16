import java.util.Scanner;

public class BaitapJAVA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap so thuc thu nhat: ");
        float sothucthu1 = scanner.nextFloat();
        System.out.println("Hay nhap so thuc thu hai: ");
        float sothucthu2 = scanner.nextFloat();
        System.out.println("Hay nhap so thuc thu ba: ");
        float sothucthu3 = scanner.nextFloat();
        if (sothucthu1 + sothucthu2 < sothucthu3 || sothucthu2 + sothucthu3 < sothucthu1
                || sothucthu1 + sothucthu3 < sothucthu2)
            System.out.println("Day khong phai la tam giac");
        else
            System.out.println("Day la 1 tam giac");
        scanner.close();
    }
}

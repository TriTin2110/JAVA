import java.util.Scanner;

public class Tinhgiatritrungbinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int[] giatri = new int[10];
        for (int i = 1; i <= n; i++) {
            System.out.print("Hay nhap gia tri cua phan tu thu " + i + ": ");
            giatri[i] = scanner.nextInt();
        }
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += giatri[i];
        }
        System.out.println("Tong cua cac phan tu ma ban da nhap la: " + tong);
    }
}

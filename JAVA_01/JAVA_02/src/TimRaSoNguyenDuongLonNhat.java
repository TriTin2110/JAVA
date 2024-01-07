import java.util.Scanner;

public class TimRaSoNguyenDuongLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap vao so luong phan tu: ");
        int n = scanner.nextInt();
        int[] giatri = new int[6];
        for (int i = 1; i <= n; i++) {
            System.out.print("Hay nhap gia tri cua phan tu thu " + i + ": ");
            giatri[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (giatri[i] > max)
                max = giatri[i];
        }
        System.out.println("Gia tri lon nhat trong mang la: " + max);
    }
}
